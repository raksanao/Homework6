package com.zerobanking.step_definitions;

import com.zerobanking.pages.LoginPage;
import com.zerobanking.utilities.BrowserUtils;
import com.zerobanking.utilities.ConfigurationReader;
import com.zerobanking.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginStepDef {
    LoginPage loginPage = new LoginPage();
    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        System.out.println("Open login page");
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
        loginPage.clickSignIn();

    }

    @When("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
        System.out.println("Login as user");
        loginPage.login("username", "password");
    }

    @Then("account summary page should be	displayed")
    public void account_summary_page_should_be_displayed() {
        System.out.println("Verify that title is a  Account Summary");
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
        WebElement ele=Driver.getDriver().findElement(By.id("account_summary_tab"));
        String summery=ele.getText();
        Assert.assertEquals("Account Summary", summery);
    }



}
