package com.zerobanking.pages;

import com.zerobanking.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;
public class AccountSummaryPage extends LoginPage {
    @FindBy(tagName = "h2")
    private List<WebElement> accountType;
    @FindBy(xpath = "(//table[1])[3]//th")
    private List<WebElement> accCreditBalance;
    @FindBy(id = "account_activity_tab")
    private WebElement accountActivity;

    public void accountActivity() {
        accountActivity.click();
    }

    @FindBy(xpath = "//select [@ id='aa_accountId']")
    private WebElement saving;
    @FindBy(xpath = "(//table[1])[1]//th")
    private List<WebElement> tarnsactionTbl;
   // @FindBy(id = "alert_content")
  // private WebElement alart;
   // @FindBy(id = "sp_account")
  // private WebElement accountOfPay;
    @FindBy(linkText = "Savings")
    private WebElement savingsLink;
    public String selectDropDown() {

        Select select = new Select(saving);
        return select.getFirstSelectedOption().getText();

    }

    public void clickToSaving() {
        savingsLink.click();
    }


    public List<String> getColumnNames(String accountType) {
        return driver.findElements(By.xpath("//h2[text()='" + accountType + "']/following-sibling::div[1]//th"))
                .stream().map(each -> each.getText()).collect(Collectors.toList());
    }

    public String title() {
        return driver.getTitle();

    }

    public void clickAccount(String account) {
        driver.findElement(By.xpath("//a[text()='" + account + "']")).click();

    }

    @FindBy(tagName = "h2")
    private List<WebElement> accountTypes;

        public List<String> accountTypeOption() {
            BrowserUtils.waitForPageToLoad(20);
            return BrowserUtils.getTextFromWebElements(accountTypes);
        }
    //just comment

}
