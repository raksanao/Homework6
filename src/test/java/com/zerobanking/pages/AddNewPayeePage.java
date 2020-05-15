package com.zerobanking.pages;

import com.zerobanking.utilities.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class AddNewPayeePage extends BasePage {
    @FindBy(xpath = "//a[contains(text(),'Add New Payee')]")
   private WebElement addNewPayee;
    public void  clickToCreat(){
        addNewPayee.click();
    }
@FindBy(xpath = "//input[@id='np_new_payee_name']")
    private WebElement payeeName;

    @FindBy(xpath = "//textarea[@id='np_new_payee_address']")
    private WebElement payeeAddress;

    @FindBy(xpath = "//input[@id='np_new_payee_account']")
    private  WebElement payeeAccount;

    @FindBy(xpath = " //input[@id='np_new_payee_details']")
    private WebElement payeeDetails;

    @FindBy(xpath = "//input[@id='add_new_payee']")
    private  WebElement payeeAdd;


    public String succsseMsg(){
        WebElement message = driver.findElement(By.id("alert_content"));
        wait.until(ExpectedConditions.visibilityOf(message));
        return message.getText();
    }


    public void fillForm(String name){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(payeeName));
        payeeName.sendKeys(name);


    }
    public void payeeAdress(String adress){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(payeeAddress));
        payeeAddress.sendKeys(adress);
    }
    public void account(String account){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(payeeAccount));
        payeeAccount.sendKeys(account);

    }
    public void payeeDetails(String datails){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(payeeDetails));
        payeeDetails.sendKeys(datails);
    }
public void add(){
        payeeAdd.click();
}



}
