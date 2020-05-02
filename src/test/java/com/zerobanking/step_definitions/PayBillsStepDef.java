package com.zerobanking.step_definitions;

import com.zerobanking.pages.AccountSummaryPage;
import com.zerobanking.pages.LoginPage;
import com.zerobanking.utilities.BrowserUtils;
import com.zerobanking.utilities.Driver;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;


public class PayBillsStepDef {
    LoginPage loginPage = new LoginPage();


    @Then("User navigates to {string}")
    public void user_navigates_to(String payBills) {
      loginPage.navigateTo( payBills);
    }
    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {

        System.out.println("Verify that title is a Zero – Pay Bills");
        BrowserUtils.waitForPageToLoad(10);
       BrowserUtils.wait(2);
        Assert.assertEquals(title, Driver.getDriver().getTitle());


    }

    @Then("User should pay saved payee with following:")
    public void user_should_pay_saved_payee_with_following(Map<String,String> dataTable) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Select select = new Select(accountSummaryPage.payee);
        select.selectByVisibleText(dataTable.get("Payee"));
        BrowserUtils.wait(3);
        Select select1 = new Select(accountSummaryPage.accountOfPay);
        select1.selectByVisibleText(dataTable.get("Account"));

        BrowserUtils.wait(4);
        accountSummaryPage.amount.sendKeys(dataTable.get("Amount"));
        BrowserUtils.wait(5);
        accountSummaryPage.date.sendKeys(dataTable.get("Date"));
        accountSummaryPage.discription.sendKeys(dataTable.get("Description"));

    }


    @Then("User should click pay button")
   public void user_should_click_pay_button() {
        AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
        accountSummaryPage.pay.click();
        BrowserUtils.wait(9);
    }


   @Then("{string} should be displayed")
    public void should_be_displayed(String paymentSuccess) {
       AccountSummaryPage accountSummaryPage=new AccountSummaryPage();
       String peymentConfirm=accountSummaryPage.alart.getText();
       Assert.assertEquals(peymentConfirm,"The payment was successfully submitted.");
       accountSummaryPage.alart.isDisplayed();


    }
    @Then("User puts following:")
    public void user_puts_following(Map<String,String> dataTable) {
        AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
        Select select = new Select(accountSummaryPage.payee);
        select.selectByVisibleText(dataTable.get("Payee"));
        BrowserUtils.wait(3);
        Select select1 = new Select(accountSummaryPage.accountOfPay);
        select1.selectByVisibleText(dataTable.get("Account"));
        accountSummaryPage.discription.sendKeys(dataTable.get("Description"));

/*this part not done yet *When	user	tries	to	make	a	payment	without	entering	the	amount	or	date,
Please	fill	out	this	field	message! should	be	displayed.
Amount	field	should	not	accept	alphabetical	or	special	characters.	Date	field	should
not	accept	alphabetical	characters.	*/


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

}
