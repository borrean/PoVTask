package com.pov.automation.dsl.pages.signup;
import com.pov.automation.dsl.methods.BaseMethods;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.openqa.selenium.By.*;

public class PoVSignup extends BaseMethods {

    private String pageUrl = "https://povio-at.herokuapp.com/users/sign_up";

    //SignUp screen
    public static final By FLD_name = id("user_name");
    public static final By FLD_email = id("user_email");
    public static final By FLD_password = id("user_password");
    public static final By FLD_ConfirmPassword = id("user_password_confirmation");
    public static final By BTN_SignUp = cssSelector("[value='Sign up']");

    //Confirmation registration screen
    public static final By LBL_RegistrationConfirmation = id("flash_notice");

    //Email validation
    public static final By LBL_EmailValidation = id("error_explanation");

    //Account deletion
    public static final By BTN_Edit = cssSelector("[href='/users/edit']");
    public static final By BTN_CancelAccount = cssSelector("[data-confirm='Are you sure?']");

    public PoVSignup(WebDriver driver, Logger log) {super(driver, log);}

    public PoVSignup openSignUpPage(){
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Page opened!");
        takeScreenshot("PageOpened");
        return this;
    }

    public PoVSignup inputName(String name){
        log.info("Entering " +name+ " into name field");
        Write(name, FLD_name);
        return this;
    }

    public PoVSignup inputEmail(String email){
        log.info("Entering " +email+ " into email field");
        Write(email, FLD_email);
        return this;
    }

    public PoVSignup inputPassword(String password){
        log.info("Entering " +password+ " into password field");
        Write(password, FLD_password);
        return this;
    }

    public PoVSignup inputConfirmPassword(String password){
        log.info("Entering " +password+ " into confirm password field");
        Write(password, FLD_ConfirmPassword);
        return this;
    }

    public PoVSignup clickSignUp(){
        log.info("Clicking on Sign Up button.");
        Click(BTN_SignUp);
        return this;
    }

    public PoVSignup confirmRegistration(){
        log.info("Checking if the registration is successful.");
        String confirmationMessage = "Welcome! You have signed up successfully.";
        String displayedMessage = Read(LBL_RegistrationConfirmation);
        Assert.assertEquals(displayedMessage, confirmationMessage);
        log.info("Registration successful.");
        return this;
    }

    public PoVSignup confirmEmailValidation(){
        log.info("Checking if the email is already registered.");
        String errorMessage = "Email has already been taken";
        String displayedMessage = Read(LBL_EmailValidation);
        Assert.assertEquals(displayedMessage,errorMessage);
        log.info("Email already registered.");
        return this;
    }

    public PoVSignup deleteAccount(){
        log.info("Deleting the account");
        Click(BTN_Edit);
        Click(BTN_CancelAccount);
        try {
            driver.switchTo().alert().accept();
        }catch(NoAlertPresentException e){
            log.info("Cannot click 'Ok' on account deletion pop up.");
        }
        return this;
    }
}
