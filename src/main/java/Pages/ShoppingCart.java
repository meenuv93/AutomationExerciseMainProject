package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart {

    WebDriver driver;

    public ShoppingCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Cart link
    @FindBy(xpath = "//a[@href='/view_cart']")
    WebElement cartLink;

    // Product row in cart
    @FindBy(xpath = "//tr[contains(@id,'product-')]")
    WebElement cartProduct;

    // Proceed to checkout
    @FindBy(xpath = "//a[contains(text(),'Proceed To Checkout')]")
    WebElement checkoutButton;

    public void openCart() {
        cartLink.click();
    }

    public boolean verifyCart() {
        return cartProduct.isDisplayed();
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }
}