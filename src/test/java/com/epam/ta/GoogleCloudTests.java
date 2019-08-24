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

        Calculator expectedCalculator = CalculatorCreator.createEstimateFromProperty();

        GoogleCloud googleCloud = new GoogleCloud(driver)
                .openPage()
                .goToCalculator()
                .createEstimate(expectedCalculator);

//        String estimatedPrice = googleCloud.readEstimatedPrice();
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
