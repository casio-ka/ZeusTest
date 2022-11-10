package com.amazon.tests;

import com.amazon.pages.AmazonLogin;
import com.amazon.pages.AmazonSearchBox;
import com.amazon.utilities.BrowserUtil;
import com.amazon.utilities.ConfigReader;
import com.amazon.utilities.TestBase;
import org.junit.jupiter.api.Test;

public class AmazonSearchBoxTest extends TestBase {

    @Test
    public void testSearchBox(){

        AmazonSearchBox amazonSearchBox = new AmazonSearchBox();
        AmazonLogin amazonLogin = new AmazonLogin();

        String username = ConfigReader.read("username");
        String password = ConfigReader.read("password");

        amazonSearchBox.goTo();
        amazonLogin.login(username,password);

        BrowserUtil.waitFor(2);
        amazonSearchBox.searchBoxBeforeClick();

        amazonSearchBox.search();
        BrowserUtil.waitFor(2);

        amazonSearchBox.searchBoxAfterClick();
        BrowserUtil.waitFor(2);
    }

}
