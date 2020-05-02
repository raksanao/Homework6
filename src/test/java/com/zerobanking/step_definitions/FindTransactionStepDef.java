package com.zerobanking.step_definitions;

import com.zerobanking.pages.AccountSummaryPage;
import com.zerobanking.pages.FindTransactionPage;
import com.zerobanking.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FindTransactionStepDef {
FindTransactionPage findTransactionPage=new FindTransactionPage();
AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
    @Given("the user accesses	the	Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
       accountSummaryPage.accountActivity.click();
        BrowserUtils.wait(4);
findTransactionPage.findTransactions.click();
BrowserUtils.wait(4);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String date, String to) {
findTransactionPage.setDate(date,to);
BrowserUtils.wait(6);

    }
    @When("clicks search")
    public void clicks_search() {
findTransactionPage.findAndClick();
BrowserUtils.wait(4);
    }
    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) {

    }
    @Then("the	results	should be sorted by	most recent	date")
    public void the_results_should_be_sorted_by_most_recent_date() {

    }
    @Then("the	results	table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {


    }

    }
