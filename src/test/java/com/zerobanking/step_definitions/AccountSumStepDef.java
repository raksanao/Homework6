package com.zerobanking.step_definitions;

import com.zerobanking.pages.AccountSummaryPage;
import com.zerobanking.utilities.BrowserUtils;
import com.zerobanking.utilities.Driver;
import io.cucumber.java.en.Then;

import org.junit.Assert;

import java.util.List;


public class AccountSumStepDef {//done
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Then("the title should be Zero – Account summary")
    public void the_title_should_be_Zero_Account_summary() {
        System.out.println("Verify that title is a Zero– Account Summary");
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
        Assert.assertEquals("Zero - Account Summary", Driver.getDriver().getTitle());
    }

    @Then("the user should see following account types")//done
    public void the_user_should_see_following_account_types(List<String> list) {
        System.out.println("Expected values: " + list);
        Assert.assertEquals(list, accountSummaryPage.accountTypeOption());


    }


    @Then("{string} table must have columns")//done
    public void table_must_have_columns(String accountType, List<String>options) {

        Assert.assertEquals(options,accountSummaryPage.getColumnNames(accountType));
    }



}





