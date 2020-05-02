package com.zerobanking.step_definitions;

import com.zerobanking.pages.LoginPage;
import com.zerobanking.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginInvalidStepDef {
LoginPage loginPage=new LoginPage();
    @When("user tries to login with invalid information")
    public void user_tries_to_login_with_invalid_information() {
        loginPage.login("user", "pas");
    }
    @Then("error message Login and or password are wrong should be displayed.")
    public void error_message_Login_and_or_password_are_wrong_should_be_displayed() {

     BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
      // loginPage.error.isDisplayed();
       String tit=loginPage.error.getText();
        Assert.assertEquals("Login and/or password are wrong.", tit);

    }


}
