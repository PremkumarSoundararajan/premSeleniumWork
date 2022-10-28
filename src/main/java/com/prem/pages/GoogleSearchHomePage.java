package com.prem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleSearchHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public GoogleSearchHomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[title^='Search']")
    public WebElement searchBox;

    @FindBy(css = "[type^='submit']")
    public WebElement submitButton;

    public void enterSearchTextInGoogleSearchBox(String inputText){
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(inputText);
    }

    public void pressSubmitButton(){
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }
}
