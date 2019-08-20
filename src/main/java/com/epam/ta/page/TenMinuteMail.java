package com.epam.ta.page;

import com.epam.ta.model.Calculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class TenMinuteMail extends AbstractPage {

    private final String MAIL_URL = "https://10minutemail.com/";
    private static final String FRAME = "idIframe";
    private static final String XPATH_PRICE_ESTIMATE = ".//a[text()='Google Cloud Platform Price Estimate']";
    private static final String XPATH_MAIL = "//*[@id='mobilepadding']/td/table/tbody/tr[1]/td[4]";

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailButton;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmail;

    @FindBy(xpath = ".//span[@class='inc-mail-subject']")
    private WebElement openEmail;

    @FindBy(id = "mailAddress")
    private WebElement emailAddress;

    public TenMinuteMail(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public TenMinuteMail openPage() {
        driver.navigate().to(MAIL_URL);
        logger.info("TenMinuteMail page opened");
        return this;
    }

//    public void switchToMailWindow(){
//        String parentWindow = driver.getWindowHandle();
//        Set<String> windowHandles = driver.getWindowHandles();
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.open('https://10minutemail.com/10MinuteMail/index.html','_ ');");
//
//        String childWindow = driver.getWindowHandle();
//        windowHandles.add(childWindow);
//        String emailCopy = emailAddress.getAttribute("value");
//        driver.switchTo().window(parentWindow);
//
//    }

    public GoogleCloud sendEmail(Calculator calculator) {

        String parentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.open('https://10minutemail.com/10MinuteMail/index.html','_ ');");

        String childWindow = driver.getWindowHandle();
        windowHandles.add(childWindow);

        String emailCopy = emailAddress.getAttribute("value");
        calculator.setEmail(emailCopy);
        driver.switchTo().window(parentWindow);
        driver.switchTo().frame(FRAME);
        emailButton.click();
        emailButton.sendKeys(emailCopy);
        sendEmail.click();
        driver.switchTo().window(MAIL_URL);
        waitVisibilityOfElementLocated(By.xpath(XPATH_PRICE_ESTIMATE));
        openEmail.click();

        return new GoogleCloud(driver);

    }

    public Calculator readEmail() {
        Calculator calculator = new Calculator();
        calculator.setEmail(driver.findElement(By.xpath(XPATH_MAIL)).getText().trim());
        return calculator;
    }
}
