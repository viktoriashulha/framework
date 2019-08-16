package com.epam.ta;

import com.epam.ta.model.Mail;
import com.epam.ta.page.TenMinuteMail;
import org.testng.annotations.Test;
import com.epam.ta.page.GoogleCloud;
import org.openqa.selenium.WebDriver;
import com.epam.ta.model.Calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class GoogleCloudTests {

    protected WebDriver driver;

    @Test
    public void oneCanCreateEstimate() {
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
                .createEstimate(expectedCalculator);
        Calculator actualCalculator = googleCloud.readEstimate();
        assertThat(expectedCalculator, is(equalTo(actualCalculator)));

    }

    @Test
    public void oneCanSendEmail(){
        Mail expectedMail = new Mail();

        TenMinuteMail tenMinuteMail = new TenMinuteMail(driver)
                .openPage()
                .sendEmail(expectedMail);
        TenMinuteMail actualMail = tenMinuteMail.readEmail();
        assertThat(expectedMail, is(equalTo(actualMail)));
    }
}
