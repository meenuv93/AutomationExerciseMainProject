package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Register {

    public WebDriver driver;

    // Locators

    @FindBy(name = "name")
    WebElement name;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement email;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    WebElement signupbutton;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "days")
    WebElement day;

    @FindBy(id = "months")
    WebElement month;

    @FindBy(id = "years")
    WebElement year;

    @FindBy(id = "first_name")
    WebElement firstname;

    @FindBy(id = "last_name")
    WebElement lastname;

    @FindBy(id = "company")
    WebElement company;

    @FindBy(id = "address1")
    WebElement address;

    @FindBy(id = "address2")
    WebElement address2;

    @FindBy(id = "country")
    WebElement country;

    @FindBy(id = "state")
    WebElement state;

    @FindBy(id = "city")
    WebElement city;

    @FindBy(id = "zipcode")
    WebElement zipcode;

    @FindBy(id = "mobile_number")
    WebElement mobile;

    @FindBy(xpath = "//button[@data-qa='create-account']")
    WebElement createaccount;


    // Constructor

    public Register(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    // Name

    public void username(String uname)
    {
        name.sendKeys(uname);
    }


    // Email

    public void email(String mail)
    {
        email.sendKeys(mail);
    }


    // Signup button

    public void signup()
    {
        signupbutton.click();
    }


    // Password

    public void password(String pass)
    {
        password.sendKeys(pass);
    }


    // Date of Birth

    public void day(String d)
    {
        Select s = new Select(day);
        s.selectByValue(d);
    }

    public void month(String m)
    {
        Select s = new Select(month);
        s.selectByValue(m);
    }

    public void year(String y)
    {
        Select s = new Select(year);
        s.selectByValue(y);
    }


    // First Name

    public void firstname(String fname)
    {
        firstname.sendKeys(fname);
    }


    // Last Name

    public void lastname(String lname)
    {
        lastname.sendKeys(lname);
    }


    // Company

    public void company(String comp)
    {
        company.sendKeys(comp);
    }


    // Address

    public void address(String add)
    {
        address.sendKeys(add);
    }

    public void address2(String add2)
    {
        address2.sendKeys(add2);
    }


    // Country

    public void country(String count)
    {
        Select s = new Select(country);
        s.selectByVisibleText(count);
    }


    // State

    public void state(String st)
    {
        state.sendKeys(st);
    }


    // City

    public void city(String ct)
    {
        city.sendKeys(ct);
    }


    // Zipcode

    public void zipcode(String zip)
    {
        zipcode.sendKeys(zip);
    }


    // Mobile Number

    public void mobile(String mob)
    {
        mobile.sendKeys(mob);
    }


    // Create Account

    public void createaccount()
    {
        createaccount.click();
    }
}