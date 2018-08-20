package com.crm.qa.testcases;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Sequence of execution
 * Test cases should be independent of each other
 * 1) Before Each test case - launch the browser & login
 * 2) Run the test cases @Test
 * 3) After each test case tear down the driver
 */

public class HomePageTest extends TestBase {

    private HomePage homePage;
    private LoginPage loginPage;
    private TestUtil testUtil;

    public HomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
        testUtil = new TestUtil();

    }

    @Test(priority = 1)
    public void verifyPageTitleTest(){
        String title = homePage.validateHomePageTitle();
        Assert.assertEquals(title,"CRMPRO","Title Mistmatch error @ verifyPageTitletest");
    }

    @Test(priority = 2)
    public void verifyUsernameTest(){
        //First jump to the frame where the username is present, then verify the user name
        testUtil.switchTo();
        boolean flag = homePage.verifyUserName();
        Assert.assertTrue(flag);
    }

//    @Test
//    public void verifyContactsPageTest(){
//        ContactsPage contactsPage = homePage.clickOnContacts();
//    }
//
//    @Test
//    public void verifyDealsPage(){
//        DealsPage dealsPage = homePage.dealsPage();
//    }



    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
