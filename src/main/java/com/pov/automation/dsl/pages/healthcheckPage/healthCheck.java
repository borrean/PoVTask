package com.pov.automation.dsl.pages.healthcheckPage;

import com.pov.automation.dsl.methods.BaseMethods;
import com.pov.automation.dsl.pages.login.PoVLogin;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.pov.automation.dsl.pages.signup.PoVSignup.*;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class healthCheck extends BaseMethods {

    public healthCheck(WebDriver driver, Logger log) {super(driver, log);}

    //MainPage locators
    public static final By BTN_SignIn = cssSelector("[href='/users/sign_in']");
    public static final By BTN_SignUp = cssSelector("[href='/users/sign_up']");

    //SignedIn page locators
    public static final By BTN_EditAccount= cssSelector("[href='/users/edit']");
    public static final By BTN_Campaigns = cssSelector("[href='/campaigns']");
    public static final By BTN_SignOut = cssSelector("[href='/users/sign_out']");

    //Edit account page locators
    public static final By TXT_EditName= id("user_name");
    public static final By TXT_EditEmail = id("user_email");
    public static final By TXT_EditPassword = id("user_password");
    public static final By TXT_EditConfirmPassword = id("user_password_confirmation");
    public static final By TXT_CurrentPassword = id("user_current_password");
    public static final By BTN_EditUpdate = cssSelector("[value='Update']");

    //App urls
    private String mainUrl = "https://povio-at.herokuapp.com";
    private String signUpUrl = "https://povio-at.herokuapp.com/users/sign_up";
    private String editAccountUrl = "https://povio-at.herokuapp.com/users/edit";


    public healthCheck checkMainPageLoad(){
        log.info("Opening page main page");
        openUrl(mainUrl);
        log.info("Page opened!");
        log.info("Checking if the elements properly loaded.");
        Exists(5,BTN_SignIn);
        Exists(3, BTN_SignIn);
        log.info("Elements loaded properly.");
        return this;
    }

    public healthCheck checkSignUpPageLoad(){
        log.info("Opening SignUp page");
        openUrl(signUpUrl);
        log.info("Page opened!");
        log.info("Checking if the elements properly loaded.");
        Exists(3,FLD_name);
        Exists(3, FLD_email);
        Exists(3, FLD_password);
        Exists(3, FLD_ConfirmPassword);
        Exists(3, BTN_SignUp);
        log.info("Elements loaded properly.");
        return this;
    }

    public healthCheck checkSignedInPageLoad(){
        log.info("SignedIn page opened!");
        log.info("Checking if the elements properly loaded.");
        Exists(3,BTN_EditAccount);
        Exists(3, BTN_Campaigns);
        Exists(3, BTN_SignOut);
        log.info("Elements loaded properly.");
        return this;
    }
    public healthCheck checkEditAccountPage(){
        log.info("Opening edit accounts page.");
        openUrl(editAccountUrl);
        log.info("SignedIn page opened!");
        log.info("Checking if the elements properly loaded.");
        Exists(3,TXT_EditName);
        Exists(3, TXT_EditEmail);
        Exists(3, TXT_EditPassword);
        Exists(3, TXT_EditConfirmPassword);
        Exists(3, TXT_CurrentPassword);
        Exists(3, BTN_EditUpdate);
        log.info("Elements loaded properly.");
        return this;
    }
}
