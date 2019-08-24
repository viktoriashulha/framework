package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TenMinuteMail extends AbstractPage {

//    private static final String XPATH_PRICE_ESTIMATE = ".//a[text()='Google Cloud Platform Price Estimate']";
//    private static final String XPATH_MAIL = "//*[@id='mobilepadding']/td/table/tbody/tr[1]/td[4]";
//    private static final String XPATH_COST = "//md-list-item[@role='listitem']//div//b";

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailButton;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmail;

    @FindBy(xpath = ".//span[@class='inc-mail-subject']")
    private WebElement openEmail;

    @FindBy(xpath = "//span[@id='email_ch_text']")
    private WebElement emailAddress;

    @FindBy(xpath = "//div[@class='e7m mess_bodiyy']//h2")
    private WebElement priceEstimate;

    public TenMinuteMail(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public TenMinuteMail openPage() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.open('https://emailfake.com','_ ');");
        logger.info("TenMinuteMail page was opened");
        return this;
    }

    public String getEmailAddress() {
        waitElementToBeVisible(emailAddress);
        return emailAddress.getText();
    }

    public String readPriceFromEmail() {
        waitElementToBeVisible(priceEstimate);
        return priceEstimate.getText();
    }
}
