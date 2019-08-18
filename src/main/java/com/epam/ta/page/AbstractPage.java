package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public abstract class AbstractPage {

    protected WebDriver driver;

    protected abstract AbstractPage openPage();

    protected final int WAIT_TIMEOUT_SECONDS = 10;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitVisibilityOfElementLocated(By element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    protected void switchTabs(){
        String parentWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.open('https://10minutemail.com/10MinuteMail/index.html','_ ');");

        String childWindow = driver.getWindowHandle();
        windowHandles.add(childWindow);
    }
}
