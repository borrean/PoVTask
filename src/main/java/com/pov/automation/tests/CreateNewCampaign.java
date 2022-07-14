package com.pov.automation.tests;

import com.pov.automation.dsl.pages.campaigns.PovCampaign;
import com.pov.automation.dsl.pages.login.PoVLogin;
import com.pov.automation.essentials.testng.BaseTest;
import org.testng.annotations.Test;

public class CreateNewCampaign extends BaseTest {

    @Test
    public void createNewCampaign(){
        PoVLogin loginTest = new PoVLogin(driver,log);

        loginTest
                .openLogInPage()
                .inputEmail("elevejt@gmail.com")
                .inputPassword("Sajonara123!")
                .clickSignInAndConfirm();

        PovCampaign campaignTest = new PovCampaign(driver,log);

        campaignTest
                .goToCampaignPage()
                .addNewCampaign()
                .enterCampaignName("test")
                .enterCampaignDescription("test")
                .createCampaignAndConfirm();
    }
}
