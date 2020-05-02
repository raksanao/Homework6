package com.zerobanking.step_definitions;

import com.zerobanking.pages.AccountSummaryPage;
import com.zerobanking.utilities.BrowserUtils;
import com.zerobanking.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import org.openqa.selenium.WebElement;


import java.util.ArrayList;
import java.util.List;

public class AccountActivityStepDef {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    @Then("the user clicks to Account	activity")
    public void the_user_clicks_to_Account_activity() {

        accountSummaryPage.accountActivity.click();
    }
        @Then("the title should be Zero – Account	activity")
        public void the_title_should_be_Zero_Account_activity() {
            System.out.println("Verify that title is a Zero– Account Activity");
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
        Assert.assertEquals("Zero - Account Activity", Driver.getDriver().getTitle());
    }

    @Then("the Account drop down default option should be Savings")
    public void the_Account_drop_down_default_option_should_be_Savings() {

      Assert.assertEquals("Saving",accountSummaryPage.selectDropDown());

    }
    @Then("the Account drop down  options should be displayed")
    public void the_Account_drop_down_options_should_be_displayed(List<String> dataTable) {

     accountSummaryPage.saving.getText();

      accountSummaryPage.saving.isDisplayed();

    }
    @Then("the transactions table should have column names")
    public void the_transactions_table_should_have_column_names(List<String> column) {
        System.out.println("list.size() = " + column.size());
        System.out.println(column);

        List<String> actualList = new ArrayList<>();
        BrowserUtils.wait(6);
        for (WebElement option : accountSummaryPage.tarnsactionTbl) {
            actualList.add(option.getText());
        }
        Assert.assertEquals(column, actualList);


    }

}
