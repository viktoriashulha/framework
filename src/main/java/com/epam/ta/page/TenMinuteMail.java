package com.epam.ta.page;

import com.epam.ta.model.Mail;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TenMinuteMail extends AbstractPage {

    private String email;

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

    public TenMinuteMail sendEmail(Mail mail) {

        String parentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.open('https://10minutemail.com/10MinuteMail/index.html','_ ');");

        String childWindow = driver.getWindowHandle();
        windowHandles.add(childWindow);
//        Mail expectedMail = new Mail();
//        switchTabs();
        String emailCopy = emailAddress.getAttribute("value");
        mail.setEmail(emailCopy);
        driver.switchTo().window(parentWindow);
        driver.switchTo().frame(FRAME);
        emailButton.click();
        emailButton.sendKeys(emailCopy);
        sendEmail.click();
        driver.switchTo().window(MAIL_URL);
        waitVisibilityOfElementLocated(By.xpath(XPATH_PRICE_ESTIMATE));
        openEmail.click();

        return new TenMinuteMail(driver);

    }

    public TenMinuteMail readEmail() {
        TenMinuteMail tenMinuteMail = new TenMinuteMail(driver);
        tenMinuteMail.setEmail(driver.findElement(By.xpath(XPATH_MAIL)).getText().trim());
        return tenMinuteMail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
