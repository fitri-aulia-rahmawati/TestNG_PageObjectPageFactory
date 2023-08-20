package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLogin {
    WebDriver driver;
    LoginPage loginPage;
    @BeforeClass
    public void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.delay(3);
        DriverSingleton.closeObjectInstance();
    }
    @Test (priority = 1)
    public void invalidLoginCredentialTest(){
        loginPage.loginForm("standard", "secret");
        Assert.assertEquals(loginPage.getTxtRequired(), "Epic sadface: Username and password do not match any user in this service");
        driver.navigate().refresh();
    }
    @Test (priority = 2)
    public void invalidLoginWithoutUname(){
        loginPage.loginForm("", "secret_sauce");
        Assert.assertEquals(loginPage.getTxtRequired(), "Epic sadface: Username is required");
        driver.navigate().refresh();
    }
    @Test (priority = 3)
    public void invalidLoginWithoutPassword(){
        loginPage.loginForm("standard_user", "");
        Assert.assertEquals(loginPage.getTxtRequired(), "Epic sadface: Password is required");
        driver.navigate().refresh();
    }
    @Test(priority = 4)
    public void validLoginTest(){
        loginPage.loginForm("standard_user", "secret_sauce");
        Assert.assertEquals(loginPage.getTxtDashboard(), "Swag Labs");
        driver.navigate().refresh();
    }

}
