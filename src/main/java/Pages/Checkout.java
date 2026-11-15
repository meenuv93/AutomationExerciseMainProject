package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {

    WebDriver driver;

    public Checkout(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Comment
    @FindBy(name = "message")
    WebElement comment;

    // Place Order
    @FindBy(xpath = "//a[contains(text(),'Place Order')]")
    WebElement placeorder;

    // Name on Card
    @FindBy(name = "name_on_card")
    WebElement cardname;

    // Card Number
    @FindBy(name = "card_number")
    WebElement cardnumber;

    // CVC
    @FindBy(name = "cvc")
    WebElement cvc;

    // Expiry Month
    @FindBy(name = "expiry_month")
    WebElement expirymonth;

    // Expiry Year
    @FindBy(name = "expiry_year")
    WebElement expiryyear;

    // Pay and Confirm Order
    @FindBy(id = "submit")
    WebElement paybutton;

    // Enter Comment
    public void comment(String msg)
    {
        comment.sendKeys(msg);
    }

    // Place Order
    public void placeorder()
    {
        placeorder.click();
    }

    // Card Name
    public void cardname(String name)
    {
        cardname.sendKeys(name);
    }

    // Card Number
    public void cardnumber(String number)
    {
        cardnumber.sendKeys(number);
    }

    // CVC
    public void cvc(String code)
    {
        cvc.sendKeys(code);
    }

    // Expiry Month
    public void expirymonth(String month)
    {
        expirymonth.sendKeys(month);
    }

    // Expiry Year
    public void expiryyear(String year)
    {
        expiryyear.sendKeys(year);
    }

    // Pay
    public void pay()
    {
        paybutton.click();
    }
}