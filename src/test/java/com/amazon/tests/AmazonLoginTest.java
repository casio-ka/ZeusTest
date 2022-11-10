package com.amazon.tests;

import com.amazon.pages.AmazonLogin;
import com.amazon.utilities.ConfigReader;
import com.amazon.utilities.TestBase;
import org.testng.annotations.Test;

public class AmazonLoginTest extends TestBase {
    AmazonLogin amazonLogin;

    @Test
    public void testLogin(){
        amazonLogin = new AmazonLogin();

        String username = ConfigReader.read("username");
        String password = ConfigReader.read("password");

        amazonLogin.goTo();
        amazonLogin.login(username,password);
    }
}
