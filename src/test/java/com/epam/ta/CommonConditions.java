package com.epam.ta;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.exceptions.IncorrectTestDataException;
import com.epam.ta.model.Tab;
import com.epam.ta.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.ArrayList;
import java.util.List;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeMethod()
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }

    public void switchToTab(Tab tab) {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());

        switch (tab) {
            case FIRST:
                driver.switchTo().window(windowHandles.get(0));
                break;
            case LAST:
                driver.switchTo().window(windowHandles.get(1));
                break;
            default:
                throw new IncorrectTestDataException();
        }

    }
}
