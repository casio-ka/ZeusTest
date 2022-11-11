package com.amazon.utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    // we want only subclasses of TestBase have access to this.
    protected WebDriver driver ;
    // setting up all driver stuff here directly in @BeforeEach method
    @BeforeTest
    public void setupWebDriver(){

        driver =  Driver.getDriver();     //WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
    }

    @AfterTest
    public void closeBrowser(){
        // quit the browser + make it null, so we can get new one when ask for it again
        Driver.closeBrowser();
    }


}
