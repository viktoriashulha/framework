package com.epam.ta.page;

import com.epam.ta.exceptions.IncorrectTestDataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.ta.model.Calculator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class GoogleCloud extends AbstractPage {

    private final String CLOUD_GOOGLE_URL = "https://cloud.google.com/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[@data-label='Tab: Pricing']")
    private WebElement linkPricing;

    @FindBy(xpath = "//a[@track-metadata-eventdetail='calculators']")
    private WebElement linkPriceCalculator;

    @FindBy(xpath = "(//input[@aria-label='quantity'])[1]")
    private WebElement inputInstanses;

    @FindBy(xpath = "//md-select[@id='select_75']")
    private WebElement mashineTypeLocator;

    @FindBy(xpath = "//md-option[@id='select_option_208']")
    private WebElement instanceTypeN1Standart1Locator;

    @FindBy(xpath = "//md-option[@id='select_option_216']")
    private WebElement instanceTypeN1Standart8Locator;

    @FindBy(xpath = "//md-option[@id='select_option_216']")
    private WebElement instanceTypeN1Highmem2Locator;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGupsLocator;

    @FindBy(xpath = "//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU' and @value='1']")
    private WebElement numberOfGupsOneLocator;

    @FindBy(xpath = "//md-option[@id='select_option_358']")
    private WebElement numberOfGupsTwoLocator;

    @FindBy(xpath = "//md-option[@id='select_option_359']")
    private WebElement numberOfGupsFourLocator;

    @FindBy(xpath = "//md-option[@id='select_option_360']")
    private WebElement numberOfGupsEightLocator;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']/md-select-value")
    private WebElement typeOfGupsLocator;

    @FindBy(xpath = "//md-option[@id='select_option_361']")
    private WebElement gpuTypeTeslaK80Locator;

    @FindBy(xpath = "//md-option[@id='select_option_362']")
    private WebElement gpuTypeTeslaP100Locator;

    @FindBy(xpath = "//md-option[@id='select_option_363']")
    private WebElement gpuTypeTeslaP4Locator;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    private WebElement gpuTypeTeslaV100Locator;

    @FindBy(xpath = "//md-option[@id='select_option_365']")
    private WebElement gpuTypeTeslaT4Locator;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPUCheckbox;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']//span[1]")
    private WebElement localSSDLocator;

    @FindBy(xpath = "//md-option[@id='select_option_166']")
    private WebElement localSSD1x35GbLocator;

    @FindBy(xpath = "//md-option[@id='select_option_170']")
    private WebElement localSSD2x375GbLocator;

    @FindBy(xpath = "//md-option[@id='select_option_168']")
    private WebElement localSSD3x375GbLocator;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement locationClickLocator;

    @FindBy(xpath = "//md-option[@id='select_option_184']")
    private WebElement locationFrankfurtLocator;

    @FindBy(xpath = "//md-option[@id='select_option_177']")
    private WebElement locationOregonLocator;

    @FindBy(xpath = "//md-select-value[@id='select_value_label_51']")
    private WebElement commitedUsageClick;

    @FindBy(xpath = "//md-option[@id='select_option_82']")
    private WebElement commitedUsage1YearLocator;

    @FindBy(xpath = "//md-option[@id='select_option_83']")
    private WebElement commitedUsage3YearsLocator;

    @FindBy(xpath = "//button[@ng-disabled='ComputeEngineForm.$invalid || !listingCtrl.isGceAvailabele']")
    private WebElement buttonAddToEstimate;

    @FindBy(xpath = "//button[@aria-label='Email Estimate']")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = ".//input[@id='input_361']")
    private WebElement emailClick;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement buttonSendEmail;

    @FindBy(xpath = ".//span[@class='inc-mail-subject']")
    private WebElement openEmail;

    private final By scriptLocator = By.xpath("//iframe[@id='idIframe']");
    private final String frame = "idIframe";

    @FindBy(xpath = "//div//input[@class='mail-address-address']")
    private WebElement emailAddress;

    @FindBy(xpath = "//button[@id='email_quote']")
    private WebElement emailButton;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmail;

    public GoogleCloud(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloud openPage() {
        driver.navigate().to(CLOUD_GOOGLE_URL);
        logger.info("GoogleCloud page opened");
        return this;
    }

    public GoogleCloud goToCalculator() {
        linkPricing.click();
        linkPriceCalculator.click();
        driver.switchTo().frame(frame);
        return new GoogleCloud(driver);
    }

    public GoogleCloud createEstimate(Calculator calculator) {

        inputInstanses.sendKeys(calculator.getNumberOfInstances());
        mashineTypeLocator.click();
        setMachineType(calculator.getInstanceType());

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(addGPUCheckbox));
        addGPUCheckbox.click();
        numberOfGupsLocator.click();
        setNumberOfGups(calculator.getNumberOfGPUs());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(typeOfGupsLocator));
        typeOfGupsLocator.click();
        setGPUType(calculator.getGpuType());
        localSSDLocator.click();
        setLocalSSD(calculator.getLocalSSD());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(locationClickLocator));
        locationClickLocator.click();
        setLocation(calculator.getRegion());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(commitedUsageClick));
        commitedUsageClick.click();
        setCommitedUsage(calculator.getCommitmentUsage());
        buttonAddToEstimate.click();

        return new GoogleCloud(driver);
    }

    private void setLocation(String region) {
        switch (region) {
            case "Region: Frankfurt":
                locationFrankfurtLocator.click();
                break;
            case "Region: Oregon":
                locationOregonLocator.click();
            default:
                throw new IncorrectTestDataException();
        }
    }

    private void setMachineType(String machineType) {
        switch (machineType) {
            case "Instance type: n1-standard-8":
                instanceTypeN1Standart8Locator.click();
                break;
            case "Instance type: n1-standard-1":
                instanceTypeN1Standart1Locator.click();
                break;
            case "Instance type: n1-highmem-2":
                instanceTypeN1Highmem2Locator.click();
                break;
            default:
                throw new IncorrectTestDataException();
        }
    }

    private void setNumberOfGups(String  numberOfGups) {
        switch (numberOfGups) {
            case "1":
                numberOfGupsOneLocator.click();
                break;
            case "2":
                numberOfGupsTwoLocator.click();
                break;
            case "4":
                numberOfGupsFourLocator.click();
                break;
            case "8":
                numberOfGupsEightLocator.click();
                break;
            default:
                throw new IncorrectTestDataException();
        }
    }

    private void setGPUType(String gpuType) {
        switch (gpuType) {
            case "NVIDIA Tesla K80":
                gpuTypeTeslaK80Locator.click();
                break;
            case "NVIDIA Tesla P100":
                gpuTypeTeslaP100Locator.click();
                break;
            case "NVIDIA Tesla P4":
                gpuTypeTeslaP4Locator.click();
                break;
            case "NVIDIA Tesla V100":
                gpuTypeTeslaV100Locator.click();
                break;
            case "NVIDIA Tesla T4":
                gpuTypeTeslaT4Locator.click();
                break;
            default:
                throw new IncorrectTestDataException();
        }
    }

    private void setLocalSSD(String ssd) {
        switch (ssd) {
            case "Total available local SSD space 1x375 GB":
                localSSD1x35GbLocator.click();
                break;
            case "Total available local SSD space 2x375 GB":
                localSSD2x375GbLocator.click();
                break;
            case "Total available local SSD space 3x375 GB":
                localSSD3x375GbLocator.click();
                break;
            default:
                throw new IncorrectTestDataException();
        }
    }

    private void setCommitedUsage(String commitedUsage) {
        switch (commitedUsage) {
            case "Commitment term: 1 Year":
                commitedUsage1YearLocator.click();
                break;
            case "Commitment term: 3 Years":
                commitedUsage3YearsLocator.click();
                break;
            default:
                throw new IncorrectTestDataException();
        }
    }

    public Calculator readEstimate() {

        Calculator calculator = new Calculator();

        calculator.setVMClass(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy ng-scope'][1]")).getText().trim());
        calculator.setInstanceType(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy'][2]")).getText().trim());
        calculator.setNumberOfInstances(driver.findElement(By.xpath("//md-list//..//span[@class='ng-binding ng-scope']")).getText().trim().replaceAll("\\D+", ""));
        calculator.setNumberOfGPUs("1");
        calculator.setGpuType("NVIDIA Tesla V100");
        calculator.setLocalSSD(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy ng-scope'][2]")).getText().trim());
        calculator.setRegion(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy'][3]")).getText().trim());
        calculator.setCommitmentUsage(driver.findElement(By.xpath("//md-list-item[@class='md-1-line md-no-proxy ng-scope'][3]")).getText().trim());
        calculator.setCost(driver.findElement(By.xpath("//md-list-item[@role='listitem']//div//b")).getText().trim());

        return calculator;
    }

}
