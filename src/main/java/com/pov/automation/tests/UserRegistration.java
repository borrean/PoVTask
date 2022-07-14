package com.pov.automation.tests;
import com.pov.automation.dsl.pages.signup.PoVSignup;
import com.pov.automation.essentials.testng.BaseTest;
import org.testng.annotations.Test;

public class UserRegistration extends BaseTest {

    @Test
    public void registerNewUser() {
        PoVSignup povSignUpPage = new PoVSignup(driver,log);
        povSignUpPage.
                openSignUpPage()
                .inputName("Dino")
                .inputEmail("elevejt@gmail.com")
                .inputPassword("Test123!")
                .inputConfirmPassword("Test123!")
                .clickSignUp()
                .confirmRegistration()
                .deleteAccount();

    }
}
