package com.zerobanking.pages;

import com.zerobanking.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.security.Key;

public class FindTransactionPage extends LoginPage {
    @FindBy(linkText = "Find Transactions")
    public WebElement findTransactions;

    @FindBy(xpath = "//button")
    public WebElement find;

    public void setDate(String date, String to) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_fromDate"))).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_fromDate"))).sendKeys(date);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_toDate"))).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_toDate"))).sendKeys(to);

    }


    public void findAndClick (){
        wait.until(ExpectedConditions.elementToBeClickable(find)).click();
        BrowserUtils.wait(1);
    }
}
