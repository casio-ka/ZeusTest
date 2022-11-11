package com.Udemy.pages;

import com.amazon.utilities.ConfigReader;
import com.amazon.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class GoogleSearch {

    @FindBy(xpath = "//input[@name=\"q\"]")
    public WebElement inputField;

    @FindBy(partialLinkText = "Udemy")
    public WebElement udemyLink;

    @FindBy(xpath = "//input[@name=\"q\"]")
    public  WebElement udemySearchBox;

    @FindBy(xpath = "//*[@id=\"u148-form-group--13\"]")
    public WebElement filterDropdown;

    public GoogleSearch(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //go to Google.com
    public void goTo(){
        Driver.getDriver().navigate().to(ConfigReader.read("url2"));
    }

    //search 'Test Automation Learning
    public void inputData(){

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(inputField).click().sendKeys("Test Automation Learning").sendKeys(Keys.RETURN).perform();
    }

    //select Udemy Link
    public void selectUdemy(){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(udemyLink).click().perform();
    }

    //confirm udemy
    public void confirmUdemy(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        WebElement teach = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"udemy\"]/div[2]/div[1]/div[3]/div[4]")));
        String confirm = teach.getText();

        assertEquals(confirm,"Teach on Udemy");

    }
    //search for "BDD with cucumber"
    public void searchUdemy(){
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(udemySearchBox).click().sendKeys("BDD with cucumber").sendKeys(Keys.RETURN).perform();

    }

    //select most highly rated course
    public void selectMostRated(){
        Select select = new Select(filterDropdown);
        select.selectByVisibleText("Highest Rated");
    }
}
