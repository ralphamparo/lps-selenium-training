package lps.selenium.training.session4.pageobjectmodel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage {
	
	WebDriver driver;
    By homePageUserName = By.xpath("//table//tr[@class='heading3']");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //Get the User name from Home Page
    public String getHomePageDashboardUserName(){
      return driver.findElement(homePageUserName).getText();
    }

}