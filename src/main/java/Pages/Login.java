package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Email Address
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement email;

    // Password
    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement password;

    // Login Button
    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginbutton;

    public void email(String mail) {
        email.sendKeys(mail);
    }

    public void password(String pass) {
        password.sendKeys(pass);
    }

    public void login() {
        loginbutton.click();
    }
}	