package com.pov.automation.dsl.pages.campaigns;

import com.pov.automation.dsl.methods.BaseMethods;
import com.pov.automation.dsl.pages.login.PoVLogin;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class PovCampaign extends BaseMethods {

    //Main screen
    public static final By BTN_Campaigns = cssSelector("[href='/campaigns']");
    public static final By BTN_CreateNewCampaign = cssSelector("[href='/campaigns/new']");

    //Campaign creation screen
    public static final By FLD_CampaignName = cssSelector("[name='campaign[name]']");
    public static final By FLD_CampaignDescription = cssSelector("[name='campaign[description]']");
    public static final By RADIO_OneTime = cssSelector("[value='one_time']");
    public static final By RADIO_Repeatble = cssSelector("[value='repetable']");
    public static final By BTN_CreateCampaign = cssSelector("[value='Create Campaign']");

    //Confirmation screen
    public static final By LBL_CampaignCreateConfrimation = id("flash_notice");

    public PovCampaign goToCampaignPage(){
        log.info("Going to campaign page");
        Click(BTN_Campaigns);
        return this;
    }

    public PovCampaign addNewCampaign(){
        log.info("Adding a new campaign");
        Click(BTN_CreateNewCampaign);
        return this;
    }

    public PovCampaign enterCampaignName(String name){
        log.info("Entering" +name+ "as campaign name.");
        Write(name, FLD_CampaignName);
        return this;
    }

    public PovCampaign enterCampaignDescription(String description){
        log.info("Entering" +description+ "as campaign description.");
        Write(description, FLD_CampaignDescription);
        return this;
    }

    public PovCampaign createCampaignAndConfirm(){
        log.info("Creating new campaign");
        Click(BTN_CreateCampaign);
        log.info("Checking if the campaign screation is successful.");
        String confirmationMessage = "Campaign was successfully created.";
        String displayedMessage = Read(LBL_CampaignCreateConfrimation);
        Assert.assertEquals(displayedMessage, confirmationMessage);
        log.info("New campaign created.");
        return this;
    }
















    public PovCampaign(WebDriver driver, Logger log) {super(driver, log);}
}
