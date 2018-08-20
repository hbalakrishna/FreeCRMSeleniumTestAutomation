package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    //Create Object Repository for the page

    //Login Username
    @FindBy(name = "username")
    private
    WebElement username;

    //Login Password
    @FindBy(name = "password")
    private
    WebElement password;

    //Login btn
    @FindBy(xpath = "//input[@type='submit']")
    private
    WebElement loginbtn;

    //Click on signup btn
    @FindBy(xpath = "//li/a[@href='https://www.freecrm.com/register/']")
    WebElement signupbtn;

    //Other xpath = (*//a/img)[1]
    //Get the logo
    @FindBy(xpath = "//div[@class='navbar-header']/*/img")
    private
    WebElement logo;

    //Initialize the object repository
    public LoginPage(){

        PageFactory.initElements(driver, this);
    }


    //Start validating

    //Methods
    public String validatePageTitle(){
        return driver.getTitle();
    }

    //Validate company logo
    public boolean validatePageLogo(){
        return logo.isDisplayed();
    }

    //Once u login, you should land on the HomePage
    public HomePage validateLogin(String loginname, String loginpass){
        username.sendKeys(loginname);
        password.sendKeys(loginpass);

//        loginbtn.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", loginbtn);


        return new HomePage();
    }

}
