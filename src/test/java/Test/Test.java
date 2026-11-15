package Test;

import org.testng.Assert;
import org.openqa.selenium.By;

import Base.Base;
import Pages.Register;
import Pages.Login;
import Pages.MyAccount;
import Pages.ViewProduct;
import Pages.ShoppingCart;
import Pages.Checkout;
import Pages.Search;
import Pages.Logout;

public class Test extends Base {

    // TC001 - Register a user

    @org.testng.annotations.Test(priority = 1)
    public void register() {

        Register r = new Register(driver);

        driver.findElement(By.linkText("Signup / Login")).click();

        r.username("Meenu");
        r.email("meenu68@gmail.com");
        r.signup();

        r.password("Meenu@123");

        r.day("16");
        r.month("9");
        r.year("1993");

        r.firstname("Meenu");
        r.lastname("Vijayan");
        r.company("ABC");
        r.address("Main Road");
        r.address2("Near Bus Stop");

        r.country("India");
        r.state("Uttar Pradesh");
        r.city("Lucknow");
        r.zipcode("226001");
        r.mobile("9876543210");

        r.createaccount();

        String url = driver.getCurrentUrl();

        Assert.assertTrue(url.contains("account_created"),
                "Account creation failed");

        driver.findElement(By.linkText("Continue")).click();

        Logout l = new Logout(driver);
        l.logout();
    }


    // TC002 - Login with valid credentials

    @org.testng.annotations.Test(priority = 2)
    public void login() {

        driver.get("https://automationexercise.com/login");

        Login l = new Login(driver);

        l.email("meenu68@gmail.com");
        l.password("Meenu@123");
        l.login();

        MyAccount m = new MyAccount(driver);

        Assert.assertTrue(m.verifyAccount(),
                "Login failed");
    }


    // TC003 - Search a product

    @org.testng.annotations.Test(priority = 3)
    public void searchProduct() {

        Search s = new Search(driver);
        
        driver.get("https://automationexercise.com/products");

        s.searchProduct("Tshirt");
        s.clickSearch();

        Assert.assertTrue(s.verifySearch(),
                "Search results not displayed");
    }


    // TC004 - View product and add to cart

    @org.testng.annotations.Test(priority = 4)
    public void viewProduct() {

    	ViewProduct v = new ViewProduct(driver);

    	v.viewProduct();

    	Assert.assertTrue(
    	    driver.getCurrentUrl().contains("product_details"),
    	    "Product page not displayed"
    	);

    	v.addToCart();
    	v.viewCart();
    }


    // TC005 - View shopping cart

    @org.testng.annotations.Test(priority = 5)
    public void viewCart() {

        ShoppingCart s = new ShoppingCart(driver);

        s.openCart();

        Assert.assertTrue(s.verifyCart(),
                "Shopping cart is empty");
    }


    // TC006 - Checkout product

    @org.testng.annotations.Test(priority = 6)
    public void checkout() {

        ShoppingCart s = new ShoppingCart(driver);

        s.openCart();

        Assert.assertTrue(s.verifyCart(),
                "Shopping cart is empty");

        s.proceedToCheckout();

        Checkout c = new Checkout(driver);

        c.comment("Please deliver the product safely");
        c.placeorder();

        c.cardname("Meenu Vijayan");
        c.cardnumber("1234567890123456");
        c.cvc("123");
        c.expirymonth("12");
        c.expiryyear("2028");

        c.pay();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("payment_done"),
                "Payment confirmation failed");
    }


    // TC007 - Logout

    @org.testng.annotations.Test(priority = 7)
    public void logout() {

        Logout l = new Logout(driver);

        l.logout();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("login"),
                "Logout failed");
    }

}