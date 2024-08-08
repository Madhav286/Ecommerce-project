package Bestbuy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchResultPage extends BasePage {

    @FindBy(css = ".sku-title a")
    private WebElement firstItemLink;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickFirstItem() {
        wait.until(ExpectedConditions.visibilityOf(firstItemLink));
        firstItemLink.click();
    }
}
