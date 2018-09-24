package com.epam.Pob;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailEmailPage {
    @FindBy(css = "a.gb_P")
    private WebElement mailBtn;
    @FindBy(css = "div.T-I.J-J5-Ji.T-I-KE.L3")
    private WebElement writeLetterBtn;
    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement receiverField;
    @FindBy(xpath = "//input[@name='subjectbox']")
    private WebElement subjectField;
    @FindBy(xpath = "//div[@role='textbox']")
    private WebElement textMessage;
    @FindBy(css = "div.T-I.J-J5-Ji.aoO.T-I-atl.L3[role='button']")
    private WebElement sendBtn;
    @FindBy(xpath = "//input[@class='gb_bf']")
    private WebElement input;
    @FindBy(css = "tbody>tr.zA.yO:nth-child(1)")
    private WebElement checkedBtn;
    @FindBy(css = "div.T-I.J-J5-Ji.nX.T-I-ax7.T-I-Js-Gs.mA>div.asa>div.ar9.T-I-J3")
    private WebElement deleteBtn;

    public GmailEmailPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void writingLetterAndSubmit(String receiver, String subject, String text) {
        mailBtn.click();
        writeLetterBtn.click();
        receiverField.sendKeys(receiver);
        subjectField.sendKeys(subject);
        textMessage.sendKeys(text);
        sendBtn.click();
    }

    public void deletingDeliveredMessage(WebDriver driver) throws InterruptedException {
        input.sendKeys("in:sent"+Keys.ENTER);
        waitForClickable(checkedBtn,driver);
        checkedBtn.click();
      //  waitForVisibility(deleteBtn,driver);
      //  Thread.sleep(3000);
        deleteBtn.click();

    }
    private void waitForVisibility(WebElement element, WebDriver driver) throws Error{
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(element));
    }
    void waitForClickable(WebElement element, WebDriver driver){
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(element));
    }
}
