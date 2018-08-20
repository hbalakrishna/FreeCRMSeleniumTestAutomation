package com.crm.qa.pages;

import com.crm.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

    @FindBy(xpath = "*//td[contains(text(),'User: Hemanth ')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactsTab;

    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealsTab;


    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement tasksTab;

    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String validateHomePageTitle(){
        return driver.getTitle();
    }

    public ContactsPage clickOnContacts(){
        contactsTab.click();
        return new ContactsPage();

    }

    public boolean verifyUserName(){
        return userNameLabel.isDisplayed();
    }

    public DealsPage dealsPage(){
        dealsTab.click();
        return new DealsPage();
    }

    public TasksPage tasksPage(){
        tasksTab.click();
        return new TasksPage();
    }



}
