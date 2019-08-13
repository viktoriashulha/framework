package com.epam.ta;

import com.epam.ta.model.Mail;
import com.epam.ta.page.TenMinuteMail;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.epam.ta.page.GoogleCloud;
import org.openqa.selenium.WebDriver;
import com.epam.ta.model.Calculator;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class GoogleCloudTests {

    protected WebDriver driver;

    @BeforeTest
    public void openChrome() {

        driver = new ChromeDriver();
        driver.manage().window();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //убрать
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void cleanToNameTests() throws InterruptedException {
        Calculator expectedCalculator = new Calculator();

        expectedCalculator.setNumberOfInstances("4");
        expectedCalculator.setVMClass("VM class: regular");
        expectedCalculator.setInstanceType("Instance type: n1-standard-8");
        expectedCalculator.setNumberOfGPUs("1");
        expectedCalculator.setGpuType("NVIDIA Tesla V100");
        expectedCalculator.setLocalSSD("Total available local SSD space 2x375 GB");
        expectedCalculator.setRegion("Region: Frankfurt");
        expectedCalculator.setCommitmentUsage("Commitment term: 1 Year");
        expectedCalculator.setCost("Estimated Component Cost: USD 1,187.77 per 1 month");


        GoogleCloud googleCloud = new GoogleCloud(driver)
                .openPage()
                .goToCalculator()
                .createEstimate(expectedCalculator)
                .sendEmail();
        Calculator actualCalculator = googleCloud.readEstimate();
        assertThat(expectedCalculator, is(equalTo(actualCalculator)));

    }

    @Test
    public void createCalculating() {
        Calculator expectedCalculator = new Calculator();

        expectedCalculator.setRegion("Region: Iowa");
        expectedCalculator.setCommitmentUsage("1-y");

        GoogleCloud googleCloud = new GoogleCloud(driver)
                .openPage()
                .goToCalculator()
                .createEstimate(expectedCalculator);

        Calculator actualCalculator = googleCloud.readEstimate();
        assertThat(expectedCalculator, is(equalTo(actualCalculator)));

    }

}
