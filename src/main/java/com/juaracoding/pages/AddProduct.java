package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProduct {
    JavascriptExecutor js;
    private WebDriver driver;
    public AddProduct(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        this.js = (JavascriptExecutor) driver;
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    WebElement btnAddBackpack;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    WebElement btnAddBikeLight;

    public void addToCart(){
        btnAddBackpack.click();
        DriverSingleton.delay(3);
        btnAddBikeLight.click();
        DriverSingleton.delay(3);
    }
}
