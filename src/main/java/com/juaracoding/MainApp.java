package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddProduct;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class MainApp {
    static WebDriver driver;
    public static void main(String[] args) {
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        System.out.println("Test Login");

        AddProduct addProduct = new AddProduct();
        addProduct.addToCart();
        System.out.println("Add Product To Cart");

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.checkout();
        System.out.println("Checkout Success");

        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
}