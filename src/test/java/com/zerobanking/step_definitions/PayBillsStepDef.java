package com.zerobanking.step_definitions;

import com.zerobanking.pages.AccountSummaryPage;
import com.zerobanking.pages.LoginPage;
import com.zerobanking.pages.PayBillsPage;
import com.zerobanking.utilities.BrowserUtils;
import com.zerobanking.utilities.Driver;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;


public class PayBillsStepDef {

    PayBillsPage payBills = new PayBillsPage();

    @Then("User navigates to {string}")
    public void user_navigates_to(String page) {
        payBills.navigateTo(page);
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String string) {
        BrowserUtils.wait(2);
        System.out.println("Verify that title is a Zero – Pay Bills");
        BrowserUtils.waitForPageToLoad(10);
       BrowserUtils.wait(2);
        Assert.assertEquals("Zero - Pay Bills", Driver.getDriver().getTitle());

    }


        @Then("User should pay saved payee with following:")
    public void user_should_pay_saved_payee_with_following(Map<String,String> dataTable) {
        payBills.selectPayee(dataTable.get("Payee"));
        payBills.selectAccount(dataTable.get("Account"));
        payBills.putAmount(dataTable.get("Amount"));
        payBills.putDate(dataTable.get("Date"));
        payBills.putDescription(dataTable.get("Description"));
    }

    @Then("User should click pay button")
    public void user_should_click_pay_button() {
        payBills.clickPay();
    }

    @Then("The success {string} should be displayed")
    public void the_success_should_be_displayed(String message) {
        Assert.assertTrue(payBills.getSuccessMessage(message).isDisplayed());
    }


    @Then("User puts following:")
    public void user_puts_following(Map<String,String> dataTable) {
        payBills.selectPayee(dataTable.get("Payee"));
        payBills.selectAccount(dataTable.get("Account"));
        payBills.putDescription(dataTable.get("Description"));
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String message) {
        Assert.assertEquals(payBills.getSummary(),message);


    }
    }





//
//

//    @Then("the title should be Zero – Pay Bills")
//    public void the_title_should_be_Zero_Pay_Bills() {
//        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
//        accountSummaryPage.payBills.click();
//BrowserUtils.wait(2);
//        System.out.println("Verify that title is a Zero – Pay Bills");
//        BrowserUtils.waitForPageToLoad(10);
//        BrowserUtils.wait(2);
//        Assert.assertEquals("Zero - Pay Bills", Driver.getDriver().getTitle());
//    }
//
//    @Then("user completes field a successful Pay operation displayed")
//    public void user_completes_field_a_successful_Pay_operation_displayed() {
//        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
//        accountSummaryPage.payBills.click();
//        Select select=new Select(accountSummaryPage.payee);
//        select.getFirstSelectedOption();
//        BrowserUtils.wait(3);
//     Select select1=new Select(accountSummaryPage.accountOfPay);
//      select1.selectByIndex(2);
//        BrowserUtils.wait(3);
//       accountSummaryPage.amount.sendKeys("200");
//        accountSummaryPage.date.click();
//        accountSummaryPage.date3.click();
//        accountSummaryPage.discription.sendKeys("I payed 200");
//        BrowserUtils.wait(7);
//       accountSummaryPage.pay.click();
//       BrowserUtils.wait(3);
//        accountSummaryPage.alart.isDisplayed();
//
//
//
//  }
////this is for not sucseseful its ot correct change it couldent find locator for that alarm
////    @Then("user clicks to Pay operation")
////    public void user_clicks_to_Pay_operation() {
////        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
////        accountSummaryPage.payBills.click();
////        accountSummaryPage.pay.click();
////    }
////
////
////
////
////    @Then("Please fill out this	field message! should be displayed")
////    public void please_fill_out_this_field_message_should_be_displayed() {
////
////    }
//


