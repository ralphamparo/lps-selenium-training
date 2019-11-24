package lps.selenium.training.session4.pagefactory.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


public class LoginPage {
	 WebDriver driver;
	 
	@FindBy(name="uid")
	WebElement usernameTextbox;
	
	@FindBy(name="password")
	WebElement passwordTextbox;
	
	@FindBy(className="barone")
    WebElement titleText;
	
	@FindBy(name="btnLogin")
	WebElement loginButton;

	public LoginPage(WebDriver driver){
	    this.driver = driver;
	    //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
	}

	//Set user name in textbox
	public void setUserName(String strUserName){
		usernameTextbox.sendKeys(strUserName);
	}

	//Set password in password textbox
	public void setPassword(String strPassword){
		passwordTextbox.sendKeys(strPassword);
	}

	//Click on login button
	public void clickLogin(){
	  loginButton.click();
	}

	//Get the title of Login Page
	public String getLoginTitle(){
	   return titleText.getText();
	}

	public void loginToHomePage(String strUserName,String strPasword){

	   //Fill user name
	   this.setUserName(strUserName);
	   //Fill password
	   this.setPassword(strPasword);
	   //Click Login button
	   this.clickLogin();        
	}
}