package com.epam.Pob;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPasswordPage {
    @FindBy(css = "input[name=\"password\"]")
    public WebElement passwordInput;
    @FindBy(id = "passwordNext")
    public WebElement passwordNextBtn;

    public GmailPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void inputPasswordAndSubmit(String password) {
        passwordInput.sendKeys(password);
        passwordNextBtn.click();
    }
}
