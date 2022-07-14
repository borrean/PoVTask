package com.pov.automation.dsl.pages.login;
import com.pov.automation.dsl.methods.BaseMethods;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class PoVLogin extends BaseMethods {

    private String pageUrl = "https://povio-at.herokuapp.com/users/sign_in";

    //Sign-in screen
    public static final By FLD_email = id("user_email");
    public static final By FLD_password = id("user_password");
    public static final By BTN_SignIn = cssSelector("[value='Sign in']");

    //Sing in confirmation
    public static final By LBL_SignUpConfirmation = id("flash_notice");

    public PoVLogin(WebDriver driver, Logger log) {super(driver, log);}

    public PoVLogin openLogInPage(){
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
        return this;
    }

    public PoVLogin inputEmail(String email){
        log.info("Entering email: " + email +" in the email field");
        Write(email,FLD_email);
        return this;
    }

    public PoVLogin inputPassword (String password){
        log.info ("Enter password" +password+ "in the password field");
        Write(password, FLD_password);
        return this;
    }

    public PoVLogin clickSignInAndConfirm (){
        log.info ("Clicking on Signing in");
        Click(BTN_SignIn);
        log.info("Checking if the SingUp is successful.");
        String confirmationMessage = "Signed in successfully.";
        String displayedMessage = Read(LBL_SignUpConfirmation);
        Assert.assertEquals(displayedMessage, confirmationMessage);
        log.info("Sign up is successful.");
        return this;
    }

}
