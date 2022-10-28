package com.prem.StepDefinitions;

import com.prem.pages.GoogleSearchHomePage;
import com.prem.pages.GoogleSearchResultsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import java.util.List;
import java.util.stream.Collectors;

public class MyStepdefs {

    private WebDriver driver;
    private GoogleSearchHomePage googleSearchHomePage;
    private GoogleSearchResultsPage googleSearchResultsPage;

    @Before
    public void setUpDriver(){
        WebDriverManager driverManager = new FirefoxDriverManager();
        driverManager.driverVersion("0.32.0").setup();
        driver = new FirefoxDriver();
        driver.get("http://www.google.com");
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshotWhenFailed");
        }
        this.driver.quit();
    }

    @Given("The user opens the Google search page")
    public void theUserOpensTheGoogleSearchPage(){
        googleSearchHomePage = new GoogleSearchHomePage(driver);
    }

    @And("The user clicks the search button")
    public void theUserClicksTheSearchButton(){
        googleSearchHomePage.pressSubmitButton();
    }

    @When("The user types {string}")
    public void theUserTypes(String searchString) {
        googleSearchHomePage.enterSearchTextInGoogleSearchBox(searchString);
    }

    @Then("The search result shows {string}")
    public void theSearchResultShows(String expectedResult) {
        googleSearchResultsPage = new GoogleSearchResultsPage(driver);
        List<WebElement> searchResults = googleSearchResultsPage.getAllSitesFromResults()
                .stream()
                .filter(e -> e.getText().startsWith(expectedResult))
                .collect(Collectors.toList());
        Assert.assertEquals(searchResults.size(),1);
    }
}
