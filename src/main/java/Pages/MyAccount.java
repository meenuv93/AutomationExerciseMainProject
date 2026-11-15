package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount {

    WebDriver driver;

    public MyAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Logged-in account confirmation
    @FindBy(xpath = "//a[@href='/logout']")
    WebElement loggedInMessage;

    // Add address details are entered during registration
    // Verify account page after successful login
    public boolean verifyAccount() {
        return loggedInMessage.isDisplayed();
    }
}
