package com.amazon.pages;

import com.amazon.utilities.ConfigReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmazonBasics {

    @FindBy(xpath = "//*[@id=\"nav-xshop\"]/a[4]")
    public WebElement amazonBasicsButton;

    @FindBy(xpath = "//*[@itemprop=\"name\"]")
    public WebElement basicsHeader;

    public void goTo(){
        Driver.getDriver().navigate().to(ConfigReader.read("url"));
    }

    public AmazonBasics(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void clickAmazonBasics(){
        this.amazonBasicsButton.click();

    }
    //Verify that results for "amazonbasics" is displayed on the top of the page (below the menu bar)
    public void afterAmazonBasicsClick(){
        String expected = basicsHeader.getText();

        System.out.println("expected =" + expected);
        assertEquals(expected,"Amazon Basics");
    }

}
