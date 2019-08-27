package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class TenMinuteMail extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

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
        logger.info("Get Email Address");
        return emailAddress.getText();
    }

    public String readPriceFromEmail() {
        waitElementToBeVisible(priceEstimate);
        return priceEstimate.getText();
    }
}
