package lps.selenium.training.session4.pageobjectmodel.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;


public class LoginPage {
	 WebDriver driver;

	By usernameTextbox = By.name("uid");
	By passwordTextbox = By.name("password");
	By titleText = By.className("barone");
	By loginButton = By.name("btnLogin");

	public LoginPage(WebDriver driver){
	    this.driver = driver;
	}

	//Set user name in textbox
	public void setUserName(String strUserName){
	    driver.findElement(usernameTextbox).sendKeys(strUserName);
	}

	//Set password in password textbox
	public void setPassword(String strPassword){
		driver.findElement(passwordTextbox).sendKeys(strPassword);
	}

	//Click on login button
	public void clickLogin(){
	   driver.findElement(loginButton).click();
	}

	//Get the title of Login Page
	public String getLoginTitle(){
	   return driver.findElement(titleText).getText();
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