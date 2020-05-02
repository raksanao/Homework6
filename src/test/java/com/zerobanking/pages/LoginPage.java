package com.zerobanking.pages;

import com.zerobanking.utilities.BrowserUtils;
import com.zerobanking.utilities.ConfigurationReader;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id="signin_button")
    protected WebElement sign_in_button;

    @FindBy(id = "user_login")
    private WebElement username;

    @FindBy(id = "user_password")
    private WebElement password;

    @FindBy(css = "input[type='submit']")
    private WebElement login;
    @FindBy(css ="div[class='alert alert-error']" )
   public WebElement error;

    public void login(String usernameValue, String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
    }





    /**
     * Method to login, version #2
     * Login as a default user
     * Credentials will be retrieved from configuration.properties file
     */
    public void login() {
        username.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
       BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
    }

    public void clickSignIn(){
            sign_in_button.click();
        }
    }



