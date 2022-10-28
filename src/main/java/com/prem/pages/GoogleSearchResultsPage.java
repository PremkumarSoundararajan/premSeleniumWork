package com.prem.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleSearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public GoogleSearchResultsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    //@FindBy(xpath = "//a[contains(@href,'trellisenergy.com')]")
    @FindBy(xpath = "//div[@class='TbwUpd NJjxre']")
    public List<WebElement> allWebSitesFromSearchResults;

    public List<WebElement> getAllSitesFromResults(){
        return allWebSitesFromSearchResults;
    }

}
