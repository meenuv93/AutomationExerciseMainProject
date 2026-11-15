package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {

    WebDriver driver;

    public Search(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "search_product")
    WebElement searchbox;

    @FindBy(id = "submit_search")
    WebElement searchbutton;

    @FindBy(xpath = "//h2[contains(text(),'Searched Products')]")
    WebElement searchresult;

    public void searchProduct(String product) {
        searchbox.sendKeys(product);
    }

    public void clickSearch() {
        searchbutton.click();
    }

    public boolean verifySearch() {
        return searchresult.isDisplayed();
    }
}