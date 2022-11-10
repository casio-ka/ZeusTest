package com.amazon.pages;


import com.amazon.utilities.ConfigReader;
import com.amazon.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AmazonSearchBox {

    @FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
    public WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"p_89/Amazon Basics\"]/span/a/div/label/input")
    public WebElement brandCheckBox;

    @FindBy(xpath = "//*[.=\"RESULTS\"]")
    public WebElement results;

    @FindBy(xpath = "//*[@id=\"p_n_feature_keywords_two_browse-bin/6813745011\"]/span/a/div/label/input")
    public WebElement size;

    @FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a")
    public WebElement item;

    @FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
    public WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div/div[3]/h1/span/span/span/span")
    public WebElement oneItem;

    public AmazonSearchBox(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public void goTo(){
        Driver.getDriver().navigate().to(ConfigReader.read("url"));
    }


    public void search(){
        this.searchBox.sendKeys("Cross-cut paper and Credit card Shredder");
        this.searchButton.click();
    }
    // Select 'Our Brands' checkbox from "From Our BRands" section on the left of the page
    public void amazonBasicsClick(){
        Actions action = new Actions(Driver.getDriver());
        action.click(brandCheckBox).perform();
    }

    public void checkBoxAfterClick(){
        assertTrue(brandCheckBox.isSelected());

    }

    //verify product page is displayed
    public void resultsDisplay(){
        assertTrue(results.isDisplayed());
    }

    //verify 8 sheet is selected - in this case its upto 9 Sheets
    public void sizeClick(){
        Actions action = new Actions(Driver.getDriver());
        action.click(size).perform();
    }
    //verify 8 sheet is selected
    public void sizeCheckBox(){
        assertTrue(size.isSelected());
    }

    //Select "AmazonBasics 8-sheet capacity,Cross-cut paper and Credit card Shedder, 4.1 Galln"
    public void selectItem(){
        item.click();
    }

    public void addItemToCart(){
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(addToCartButton).click().perform();

    }
    public void clickRejectProtection(){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement elementBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"attachSiNoCoverage\"]/span/input")));
        elementBtn.click();

    }

    //Verify item added to cart
    public void checkAddedToCart(){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement addedToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"attachDisplayAddBaseAlert\"]/span")));
        addedToCart.getText();

        assertEquals(addedToCart.getText(),"Added to Cart");
    }

    public void checkout(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement proceedToCheckout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"attach-sidesheet-checkout-button\"]/span/input")));
        proceedToCheckout.click();
    }

    //Verify Cart Shows Count as One
    public void checkOneItem(){

        assertEquals(oneItem.getText(),"1 item");
    }

}
