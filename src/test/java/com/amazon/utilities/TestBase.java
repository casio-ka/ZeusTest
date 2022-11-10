package com.amazon.utilities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    // we want only subclasses of TestBase have access to this.
    protected WebDriver driver ;
    // setting up all driver stuff here directly in @BeforeEach method
    @BeforeEach
    public void setupWebDriver(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver =  Driver.getDriver() ;     //WebDriverFactory.getDriver("chrome");
        // This is how we can set maximum timeout for finding element
        // in this example it will wait for 10 seconds
        // if element is found in 1 second ,it will just move on without finishing 10 seconds
        // Thread.sleep(100000) will always wait for 10 seconds no matter what.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
    }

    @AfterEach
    public void closeBrowser(){ // you can call it anything you want

        //driver.quit();
        // quit the browser + make it null, so we can get new one when ask for it again
        Driver.closeBrowser();
    }


}
