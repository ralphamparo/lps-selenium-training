package lps.selenium.training.session4.pagefactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage {
	
	WebDriver driver;
	@FindBy(xpath = "//table//tr[@class='heading3']")
	WebElement homePageUserName;
    
    public HomePage(WebDriver driver){
        this.driver = driver;
      //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    //Get the User name from Home Page
    public String getHomePageDashboardUserName(){
      return homePageUserName.getText();
    }

}