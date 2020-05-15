package com.zerobanking.pages;

import com.zerobanking.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForegnCurencyPage  extends LoginPage {

    @FindBy(xpath = "//a[contains(text(),'Purchase Foreign Currency')]")
    private WebElement foreignCurrencyTab;

    public void clickToForeginCurencyTab() {
        foreignCurrencyTab.click();
    }

    @FindBy(xpath = "//select[@id='pc_currency']")
    private WebElement currency;

    public List<String>getListCurrency(){
        Select select=new Select(currency);

        List<WebElement> list = select.getOptions();
        list.remove(0);
        return BrowserUtils.getTextFromWebElements(list);
    }
}
