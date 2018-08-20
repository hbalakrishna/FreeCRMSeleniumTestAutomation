package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    private LoginPage loginPage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();

    }

    //Page Title Validation
    @Test
    public void loginPageTitle(){
        String title = loginPage.validatePageTitle();
        Assert.assertEquals(title,"#1 Free CRM software in the cloud for sales and service");
    }

    //Logo Display Validation
    @Test
    public void logoDisplay(){
        boolean flag = loginPage.validatePageLogo();
        Assert.assertTrue(flag);
    }


    //Login test
    @Test
    public void loginTest(){
        HomePage homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
