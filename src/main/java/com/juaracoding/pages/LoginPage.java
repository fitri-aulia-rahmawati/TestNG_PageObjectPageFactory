package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    // Locator @FindBy
    @FindBy(xpath = "//input[@id='user-name']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    WebElement btnLogin;

    @FindBy(xpath = "//div[@class='header_label']")
    WebElement txtDashboard;
    @FindBy(xpath = "//h3[@data-test='error']")
    WebElement txtRequired;

    // Custom Method
    public void login(){
        username.sendKeys("standard_user");
        password.sendKeys("secret_sauce");
        btnLogin.click();
        DriverSingleton.delay(3);
    }
    public void loginForm(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        btnLogin.click();
    }

    // Method return

    public String getTxtDashboard() {
        return txtDashboard.getText();
    }

    public String getTxtRequired() {
        return txtRequired.getText();
    }
}
