package com.zerobanking.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class AccountSummaryPage extends BasePage {
    @FindBy(tagName = "h2")
    public List<WebElement> accountType;
    @FindBy(xpath = "(//table[1])[3]//th")
    public List<WebElement> accCreditBalance;

    @FindBy(id = "account_activity_tab")
    public WebElement accountActivity;

    @FindBy(xpath = "//select [@ id='aa_accountId']")
    public WebElement saving;


    @FindBy(xpath = "(//table[1])[1]//th")
    public List<WebElement> tarnsactionTbl;


    @FindBy(css = "input[id='sp_amount']")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(id = "sp_description")
    public WebElement discription;
    @FindBy(id = "pay_saved_payees")
    public WebElement pay;


    @FindBy(id = "alert_content")
    public WebElement alart;


    @FindBy(id = "sp_payee")
    public WebElement payee;
    @FindBy(id = "sp_account")
    public WebElement accountOfPay;

@FindBy(linkText = "Savings")
public WebElement savingsLink;
   public String selectDropDown() {

       Select select=new Select(saving);
       return select.getFirstSelectedOption().getText();

   }
   public void clickToSaving(){
       savingsLink.click();
   }



    public List<String> getColumnNames(String accountType) {
        return driver.findElements(By.xpath("//h2[text()='" + accountType + "']/following-sibling::div[1]//th"))
                .stream().map(each -> each.getText()).collect(Collectors.toList());
    }
    public String title(){
        return driver.getTitle();

    }
    public void clickAccount(String account){
        driver.findElement(By.xpath("//a[text()='"+account+"']")).click();

    }

    }
