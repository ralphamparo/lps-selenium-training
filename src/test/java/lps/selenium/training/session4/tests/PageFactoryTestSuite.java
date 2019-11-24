package lps.selenium.training.session4.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;
import lps.selenium.training.session4.pagefactory.pages.HomePage;
import lps.selenium.training.session4.pagefactory.pages.LoginPage;

public class PageFactoryTestSuite {
	
	//set webdriver.chrome.driver to define chromedriver executable filepath
	String projectBasePath = "C:\\Users\\ramparo\\eclipse-workspace\\lps-selenium-training\\";
    String webDriverValue = "geckodriver.exe";
    
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeTest
    public void setup(){
    	System.setProperty("webdriver.gecko.driver", projectBasePath + webDriverValue);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/V4/");
    }
    
    @AfterTest()
    public void teardown() {
    	driver.close();
    	driver.quit();
    }
    /**

     * This test case will login in http://demo.guru99.com/V4/

     * Verify login page title as guru99 bank

     * Login to application

     * Verify the home page using Dashboard message

     */

    @Test(priority=0)

    public void test_Home_Page_Appear_Correct(){

    //Create Login Page object
    loginPage = new LoginPage(driver);

    //Verify login page title
    String loginPageTitle = loginPage.getLoginTitle();

    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));

    //login to application
    loginPage.loginToHomePage("mgr123", "mgr!23");

    // go the next page
    homePage = new HomePage(driver);

    //Verify home page
    Assert.assertTrue(homePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
    
    }
}