package com.zerobanking.step_definitions;

import com.zerobanking.pages.PayBillsPage;
import com.zerobanking.pages.PurchaseForegnCurencyPage;
import com.zerobanking.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class PurchasForegnCurency {

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {

        PurchaseForegnCurencyPage pfp = new PurchaseForegnCurencyPage();
        pfp.clickToForeginCurencyTab();
        BrowserUtils.wait(5);
        Assert.assertEquals(dataTable, pfp.getListCurrency());

    }
}