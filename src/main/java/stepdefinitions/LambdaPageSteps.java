package stepdefinitions;


import PageObjectModels.LambdaPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class LambdaPageSteps {

    WebDriver driver;
    LambdaPage lp;
    @Given("navigate to Lambda Test eCommerce Playground Website")
    public void navigate_to_lambda_test_e_commerce_playground_website() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://ecommerce-playground.lambdatest.io/");
        lp = new LambdaPage(driver);




    }

   // And or When can be used for @And.
    @And("click on {string} button")
    public void click_on_button(String string) {
    lp.clickSubmit();
    }
    @When("enter a predefined search query {string}")
    public void enter_a_predefined_search_query(String string) {
        lp.enterText("iphone");
        lp.clickSubmit();
    }

    @Then("user should get relevant search items")
    public void user_should_get_relevant_search_items() {

        System.out.println("User should get relevant search items");
    }


    @When("enter a search query {string}")
    public void enter_a_search_query(String string) {
        lp.enterText("iphone");
        try{
            Thread.sleep(5000);
        }
        catch(Exception e){
            System.out.println("Exception");

        }
        lp.clickSubmit();
    }

    @When("click on {string} filter option")
    public void click_on_filter_option(String string) {
        lp.enterCategory();
        lp.clickSearch();
    }

    @Then("user should get relevant filtered search items")
    public void user_should_get_relevant_filtered_search_items() {
        System.out.println("user should get relevant filtered searched items");

    }


    @When("enter a invalid search as {string}")
    public void enter_a_invalid_search_as(String string) {
     lp.enterText("dz343434");
     lp.clickSubmit();
    }

    @Then("user should not get any relevant items")
    public void user_should_not_get_any_relevant_items() {
        System.out.println("User should not get any relevant items");

    }
    @Then("capture screenshot to validate")
    public void capture_screenshot_to_validate() {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("InvalidSearch.png");
        try {
            FileUtils.copyFile(screenshotFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @When("enter search query {string}")
    public void enter_search_query(String string) {
        lp.enterText("canon EOS 5D");
        lp.clickSubmit();
    }

    @Then("user should get related search items")
    public void user_should_get_related_search_items() {
        System.out.println("User should get related search items");

    }
    @Then("click one of the search items")
    public void click_one_of_the_search_items() {
        lp.clickCameraProduct();

    }
    @Then("capture the screenshot to validate")
    public void capture_the_screenshot_to_validate() {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("ProductDetails.png");
        try {
            FileUtils.copyFile(screenshotFile, destinationFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

