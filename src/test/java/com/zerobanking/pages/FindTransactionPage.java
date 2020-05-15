package com.zerobanking.pages;

import com.zerobanking.utilities.BrowserUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;


public class FindTransactionPage extends LoginPage {

    public void findTranscation() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Find Transactions"))).click();

    }

    @FindBy(xpath = "//button")
    private WebElement find;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//td[1]")
    private List<WebElement> listDate;
    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//th[contains(text(),'Description')]")
    private List<WebElement> listDescription;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//th[contains(text(),'Deposit')] ")
    private List<WebElement> listDeposit;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//th[contains(text(),'Withdrawal')] ")
    private List<WebElement> listWithdrawal;

    public void setDate(String date, String to) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_fromDate"))).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_fromDate"))).sendKeys(date);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_toDate"))).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_toDate"))).sendKeys(to);

    }


    public void findAndClick() {
        wait.until(ExpectedConditions.elementToBeClickable(find)).click();
        BrowserUtils.wait(1);
    }

    public void setDescription(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_description"))).clear();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("aa_description"))).sendKeys(text);
    }

    public List<Integer> getListOfDate() {
        List<String> lst = BrowserUtils.getTextFromWebElements(listDate);
        List<Integer> list = new ArrayList<>();
        for (String each : lst) {
            list.add(Integer.parseInt(each.split("-")[2].substring(1, 2)));
        }
        return list;
    }

    public List<String> getStringDates() {
        return BrowserUtils.getTextFromWebElements(listDate);

    }
    public List<String> getListDescription() {
        return BrowserUtils.getTextFromWebElements(listDescription);
    }
}