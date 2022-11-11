package com.amazon.tests;

import com.amazon.pages.AmazonLogin;
import com.amazon.pages.AmazonSearchBox;
import com.amazon.utilities.BrowserUtil;
import com.amazon.utilities.ConfigReader;
import com.amazon.utilities.TestBase;
import org.testng.annotations.Test;

public class AmazonGoogleSearchBoxTest extends TestBase {
    AmazonSearchBox amazonSearchBox;

    @Test
    public void testSearchBox() {

        amazonSearchBox = new AmazonSearchBox();
        AmazonLogin amazonLogin = new AmazonLogin();

        String username = ConfigReader.read("username");
        String password = ConfigReader.read("password");

        amazonSearchBox.goTo();
        amazonLogin.login(username,password);

        amazonSearchBox.search();

        amazonSearchBox.resultsDisplay();
        BrowserUtil.waitFor(2);

        amazonSearchBox.sizeClick();
        BrowserUtil.waitFor(2);

        amazonSearchBox.amazonBasicsClick();
        BrowserUtil.waitFor(3);

        amazonSearchBox.checkBoxAfterClick();
        BrowserUtil.waitFor(3);

        amazonSearchBox.sizeCheckBox();

        amazonSearchBox.selectItem();
        BrowserUtil.waitFor(1);

        amazonSearchBox.addItemToCart();

        amazonSearchBox.clickRejectProtection();
        BrowserUtil.waitFor(2);

        amazonSearchBox.checkAddedToCart();

        amazonSearchBox.checkout();

        amazonSearchBox.checkOneItem();


    }

}
