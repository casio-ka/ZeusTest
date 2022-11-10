package com.amazon.pages;

import com.amazon.utilities.ConfigReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AmazonSearchBox {

    @FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
    public WebElement searchButton;

    public AmazonSearchBox(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public void goTo(){
        Driver.getDriver().navigate().to(ConfigReader.read("url"));
    }

    public void search(){
        this.searchBox.sendKeys("amazon basics");
        this.searchButton.click();

    }
    public void searchBoxBeforeClick(){
        String expected = searchBox.getAttribute("value");
        System.out.println("expected = "+expected);
        assertEquals(expected,"");

    }

    public void searchBoxAfterClick(){
        String expected = searchBox.getAttribute("value");

        System.out.println("expected = "+expected);
        assertEquals(expected,"amazon basics");

    }

}
