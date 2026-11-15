package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewProduct {

    WebDriver driver;

    public ViewProduct(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//u[normalize-space()='View Cart']/parent::a")
    WebElement viewCartLink;
    
    // T-shirt from search results
    @FindBy(xpath = "//div[contains(@class,'product-image-wrapper')]//p[contains(translate(.,'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvwxyz'),'shirt')]/ancestor::div[contains(@class,'product-image-wrapper')]//a[contains(@href,'product_details')]")
    WebElement viewProductLink;

    // Add to Cart button
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCartButton;

 

    public void viewProduct() {
        viewProductLink.click();
    }

    public void addToCart() {
        addToCartButton.click();
    }
    public void viewCart() {
        viewCartLink.click();
    }
  
    }
