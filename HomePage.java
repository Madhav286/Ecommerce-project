package Bestbuy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "gh-search-input")
    private WebElement searchInput;

    @FindBy(css = ".header-search-button")
    private WebElement searchButton;

    @FindBy(css = "footer a")
    private List<WebElement> bottomLinks;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open(String url) {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public void searchForItem(String item) {
        searchInput.sendKeys(item);
        searchButton.click();
    }

    public List<WebElement> getBottomLinks() {
        return bottomLinks;
    }
}
