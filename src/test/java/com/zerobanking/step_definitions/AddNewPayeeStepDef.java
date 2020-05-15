package com.zerobanking.step_definitions;

import com.zerobanking.pages.AddNewPayeePage;
import com.zerobanking.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class AddNewPayeeStepDef {

    AddNewPayeePage addNewPayeePage=new AddNewPayeePage();
    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {

addNewPayeePage.clickToCreat();
        BrowserUtils.wait(5);
    }


    @Given("creates	new	payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {
addNewPayeePage.fillForm(dataTable.get("Payee Name"));

addNewPayeePage.fillForm(dataTable.get("Payee Address"));
BrowserUtils.waitForPageToLoad(20);
addNewPayeePage.fillForm(dataTable.get("Account"));
BrowserUtils.waitForPageToLoad(20);
addNewPayeePage.fillForm(dataTable.get("Payee details"));
BrowserUtils.wait(2);
addNewPayeePage.add();
    }




        @Then("message {string} should be displayed")
        public void message_should_be_displayed(String message) {
            Assert.assertEquals(addNewPayeePage.succsseMsg(),message);

    }
}