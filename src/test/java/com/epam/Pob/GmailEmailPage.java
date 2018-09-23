package com.epam.Pob;

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
    @FindBy(css = "span#link_vsm.ag.a8k>a")
    private WebElement sentMessages;
    @FindBy(css = "tbody>tr.zA.yO:nth-child(1)>td>div[role='checkbox'][id=':ai']")
    private WebElement checkedBtn;
    @FindBy(css = "div.T-I.J-J5-Ji.nX.T-I-ax7.T-I-Js-Gs.mA")
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

    public void deletingDeliveredMessage(WebDriver driver) {
        waitForVisibility(sentMessages,driver);
        sentMessages.click();
        checkedBtn.click();
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
