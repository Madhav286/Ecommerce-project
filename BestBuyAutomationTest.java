package Bestbuy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BestBuyAutomationTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        // Setup WebDriver
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");  // For headless mode
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void openBestBuyWebsite() {
        // Task 1: Open Web Browser and Navigate to Best Buy Website
        driver.get("https://www.bestbuy.com/");
        Assert.assertEquals(driver.getTitle(), "Best Buy | Official Online Store | Shop Now & Save");
    }

    @Test(priority = 2)
    public void validateURL() {
        // Task 2: Validate if the Given URL is Broken
        int statusCode = getHttpResponseStatusCode("https://www.bestbuy.com/");
        Assert.assertEquals(statusCode, 200);
    }

    @Test(priority = 3)
    public void signUpAndLogin() {
        // Task 3: Sign-Up and Login Functionality
        // Implement sign-up and login functionality with positive and negative test cases
    }

    @Test(priority = 4)
    public void navigationAndValidation() {
        // Task 4: Navigation of all Menus and Validation of Title in Each Page
        // Implement navigation and validation of menu items
    }

    @Test(priority = 5)
    public void validateBottomLinks() {
        // Task 5: Validate the Bottom Links on the Homepage
        List<WebElement> bottomLinks = driver.findElements(By.cssSelector("footer a"));
        for (WebElement link : bottomLinks) {
            String url = link.getAttribute("href");
            int statusCode = getHttpResponseStatusCode(url);
            Assert.assertEquals(statusCode, 200);
        }
    }

    @Test(priority = 6)
    public void searchAndAddItemToCart() {
        // Task 6: Search for and Add an Item to the Shopping Cart
        driver.findElement(By.id("gh-search-input")).sendKeys("laptop");
        driver.findElement(By.cssSelector(".header-search-button")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".sku-title")));
        driver.findElement(By.cssSelector(".sku-title a")).click();
        driver.findElement(By.cssSelector(".add-to-cart-button")).click();
    }

    @Test(priority = 7)
    public void selectAndAddItemByDepartment() {
        // Task 7: Select and Add an Item from Menu à Shop by Department
        // Implement selection and addition from department menu
    }

    @Test(priority = 8)
    public void selectAndAddItemByBrand() {
        // Task 8: Select and Add an Item from Menu à Brands à Select Any Brand
        // Implement selection and addition from brand menu
    }

    @Test(priority = 9)
    public void navigateToCheckoutAndFillForm() {
        // Task 9: Navigate to the Checkout Page and Fill Out the Form with Dummy Payment Information
        driver.findElement(By.cssSelector(".checkout-buttons__checkout")).click();
        // Fill out the form
    }

    @Test(priority = 10)
    public void verifyOrderPlacement() {
        // Task 10: Verify Order Placement by Checking the Resulting Web Page for Order Confirmation Message
        // Implement verification of order placement
    }

    @Test(priority = 11)
    public void closeBrowser() {
        // Task 11: Close the Web Browser When Testing is Complete
        driver.quit();
    }

    // Helper method to get HTTP response status code
    private int getHttpResponseStatusCode(String url) {
        // Implement logic to get the HTTP status code of the URL
        return 200; // Placeholder
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


