package com.zerobanking.step_definitions;

import com.zerobanking.pages.AccountSummaryPage;
import com.zerobanking.utilities.BrowserUtils;
import com.zerobanking.utilities.Driver;
import io.cucumber.java.en.Then;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;



public class AccountSumStepDef {//done
    @Then("the title should be Zero – Account summary")
    public void the_title_should_be_Zero_Account_summary() {
        System.out.println("Verify that title is a Zero– Account Summary");
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(2);
        Assert.assertEquals("Zero - Account Summary", Driver.getDriver().getTitle());
    }

    @Then("the user should see following account types")//done
    public void the_user_should_see_following_account_types(List<String> list) {
        System.out.println("list.size() = " + list.size());
        System.out.println(list);

        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
      List<String> actualList = new ArrayList<>();
        for (WebElement option : accountSummaryPage.accountType) {
            actualList.add(option.getText());
        }
        // compare actual list to the expected list
        Assert.assertEquals(list, actualList);


    }


    @Then("{string} table must have columns")//done
    public void table_must_have_columns(String accountType, List<String>options) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Assert.assertEquals(options,accountSummaryPage.getColumnNames(accountType));
    }



}





