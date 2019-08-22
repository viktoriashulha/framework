package com.epam.ta;

import com.epam.ta.model.Tab;
import com.epam.ta.page.TenMinuteMail;
import com.epam.ta.service.CalculatorCreator;
import org.testng.annotations.Test;
import com.epam.ta.page.GoogleCloud;
import com.epam.ta.model.Calculator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class GoogleCloudTests extends CommonConditions {

    @Test
    public void oneCanCreateEstimate() {

//        Calculator expectedCalculator = CalculatorCreator.createEstimateFromProperty();
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
        expectedCalculator.setEmail("Google Cloud Platform Price Estimate");

        GoogleCloud googleCloud = new GoogleCloud(driver)
                .openPage()
                .goToCalculator()
                .createEstimate(expectedCalculator);

        TenMinuteMail tenMinuteMail = new TenMinuteMail(driver);
        tenMinuteMail.openPage();
        switchToTab(Tab.LAST);
        String emailAddress = tenMinuteMail.getEmailAddress();
        System.out.println(emailAddress);
        switchToTab(Tab.FIRST);
        String estimatedPrice = "Estimated Monthly Cost: USD 1,187.77";
        googleCloud.sendEstimate(emailAddress);
        switchToTab(Tab.LAST);
        String priceFromEmail = tenMinuteMail.readPriceFromEmail();

        assertThat(estimatedPrice, is(equalTo(priceFromEmail)));

    }
}
