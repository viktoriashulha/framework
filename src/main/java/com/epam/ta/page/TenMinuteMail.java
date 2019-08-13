package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TenMinuteMail extends AbstractPage {

    private final String MAIL_URL = "https://10minutemail.com/";

    @FindBy(id = "mailAddress")
    private WebElement emailAddress;

    public String emailCopy = emailAddress.getAttribute("value");

    public TenMinuteMail(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public TenMinuteMail openPage() {
        driver.navigate().to(MAIL_URL);
        return this;
    }

    public String getEmailCopy() {
        return emailCopy;
    }

    public void setEmailCopy(String emailCopy) {
        this.emailCopy = emailCopy;
    }
}
