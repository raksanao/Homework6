package com.zerobanking.step_definitions;

import com.zerobanking.pages.AccountSummaryPage;
import com.zerobanking.pages.FindTransactionPage;
import com.zerobanking.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class FindTransactionStepDef {
FindTransactionPage findTransactionPage=new FindTransactionPage();
AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
    @Given("the user accesses	the	Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
       accountSummaryPage.accountActivity();
        BrowserUtils.wait(4);
findTransactionPage.findTranscation();
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
    public void results_table_should_only_show_transactions_dates_between_to(String date, String to) {
      for (Integer listDate : findTransactionPage.getListOfDate()) {
            Assert.assertTrue(listDate>=Integer.parseInt(date.split("-")[2].substring(1,2))
                   && listDate<=Integer.parseInt(to.split("-")[2].substring(1,2)));
       }
    }
    @Then("the	results	should be sorted by	most recent	date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        for (int i = 0; i <findTransactionPage.getListOfDate().size()-1 ; i++) {
            Assert.assertTrue(findTransactionPage.getListOfDate().get(i)>findTransactionPage.getListOfDate().get(i+1));
        }
    }
    @Then("the	results	table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {

        for (String date : findTransactionPage.getStringDates()) {
            Assert.assertNotEquals(string, date);
        }

    }
    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        findTransactionPage.setDescription(string);
        BrowserUtils.wait(1);
    }

    @Then("result table should only show descriptions containing {string}")
    public void result_table_should_only_show_descriptions_containing(String online) {
        for (String each : findTransactionPage.getListDescription()) {
            BrowserUtils.wait(5);
          Assert.assertTrue(each.contains(online));
            System.out.println("Each desc: " + each + " contains " + online);

        }
    }
    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        for (String each : findTransactionPage.getListDescription()) {
            Assert.assertFalse(each.contains(string));
            System.out.println("Each desc: " + each + " not contains " + string);
        }


    }




}
