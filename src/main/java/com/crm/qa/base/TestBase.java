package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected static WebDriver driver;
    protected static Properties prop;

    public TestBase(){
        //Fetch the properties from the config.properties file
        try
        {
            prop = new Properties();
            FileInputStream ip = new FileInputStream("/Users/hemanthbalakrishna/IdeaProjects/FreeCRMTestAutomation/src/main/java/com/crm/qa/config/config.properties");

            prop.load(ip);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void initialization() {
        //Get the browsername from the properties files
      String browsername = prop.getProperty("browser");

      if(browsername.equals("chrome")){
          System.setProperty("webdriver.chrome.driver","/Users/hemanthbalakrishna/IdeaProjects/FreeCRMTestAutomation/chromedriver");
          driver = new ChromeDriver();
      } else if(browsername.equals("FF")){
          System.setProperty("webdriver.gecko.driver","/Users/hemanthbalakrishna/IdeaProjects/FreeCRMTestAutomation/geckodriver");
          driver = new FirefoxDriver();
      }

      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);

      //Get the index page url from teh config file
      driver.get(prop.getProperty("url"));

    }
}
