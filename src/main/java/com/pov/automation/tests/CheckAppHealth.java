package com.pov.automation.tests;

import com.pov.automation.dsl.pages.campaigns.PovCampaign;
import com.pov.automation.dsl.pages.healthcheckPage.healthCheck;
import com.pov.automation.dsl.pages.login.PoVLogin;
import com.pov.automation.essentials.testng.BaseTest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.pov.automation.essentials.testUtilities.ExtentReports.ExtentTestManager.startTest;

public class CheckAppHealth extends BaseTest {

    @Test(description = "Check health of the application by checking if elements are present.")
    public void checkAppHealth(Method method){
        startTest(method.getName(), "Check health of the application by checking if elements are present.");
        healthCheck checkHealth = new healthCheck(driver,log);
        checkHealth
                .checkMainPageLoad()
                .checkSignUpPageLoad();

        PoVLogin loginTest = new PoVLogin(driver,log);
        loginTest
                .openLogInPage()
                .inputEmail("elevejt@gmail.com")
                .inputPassword("Test123!")
                .clickSignInAndConfirm();

        checkHealth
                .checkSignedInPageLoad()
                .checkEditAccountPage();

        PovCampaign campaignTest = new PovCampaign(driver,log);
        campaignTest
                .goToCampaignPage()
                .addNewCampaign()
                .enterCampaignName("test")
                .enterCampaignDescription("test")
                .createCampaignAndConfirm();
    }
}
