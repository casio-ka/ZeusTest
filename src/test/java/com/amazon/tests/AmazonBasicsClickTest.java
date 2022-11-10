package com.amazon.tests;

import com.amazon.pages.AmazonBasics;
import com.amazon.pages.AmazonLogin;
import com.amazon.utilities.BrowserUtil;
import com.amazon.utilities.ConfigReader;
import com.amazon.utilities.TestBase;
import org.testng.annotations.Test;


public class AmazonBasicsClickTest extends TestBase {

    AmazonBasics amazonBasics;
    AmazonLogin amazonLogin;

    @Test
    public void testAmazonBasic(){
        amazonBasics = new AmazonBasics();
        amazonLogin = new AmazonLogin();

        String username = ConfigReader.read("username");
        String password = ConfigReader.read("password");

        amazonBasics.goTo();
        amazonLogin.login(username,password);

        BrowserUtil.waitFor(2);
        amazonBasics.clickAmazonBasics();

        BrowserUtil.waitFor(2);
        amazonBasics.afterAmazonBasicsClick();
        BrowserUtil.waitFor(2);

    }


}
