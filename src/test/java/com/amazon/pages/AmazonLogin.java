package com.amazon.pages;

import com.amazon.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class homepage {

    

    public homepage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



}
