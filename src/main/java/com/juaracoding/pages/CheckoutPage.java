package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    JavascriptExecutor js;
    private WebDriver driver;

    public CheckoutPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement btnShoppingCart;
    @FindBy(xpath = "//button[@id='checkout']")
    WebElement btnCheckout;

    @FindBy(xpath = "//input[@id='first-name']")
    WebElement fieldFirstName;
    @FindBy(xpath = "//input[@id='last-name']")
    WebElement fieldLastName;
    @FindBy(xpath = "//input[@id='postal-code']")
    WebElement fieldZIP;
    @FindBy(xpath = "//input[@id='continue']")
    WebElement btnContinueOrder;
    @FindBy(xpath = "//button[@id='finish']")
    WebElement btnFinishOrder;

    public void checkout(){
        btnShoppingCart.click();
        btnCheckout.click();
        DriverSingleton.delay(3);
        this.fieldFirstName.sendKeys("Fitri");
        this.fieldLastName.sendKeys("Aulia");
        this.fieldZIP.sendKeys("16431");
        js.executeScript("window.scrollBy(0,200)");
        DriverSingleton.delay(3);
        btnContinueOrder.click();
        js.executeScript("window.scrollBy(0,500)");
        DriverSingleton.delay(3);
        btnFinishOrder.click();
    }
}
