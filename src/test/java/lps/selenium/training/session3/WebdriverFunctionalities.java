package lps.selenium.training.session3;

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

public class WebdriverFunctionalities {
	
	/*
	 * Session 3 - Training Outline
		1 - An Overview of frequently used Webdriver methods
		    get();
		    navigate();
			getCurrentUrl();
			getTitle();
			close();
			quit();
			findElement();
			findElements();
		2 - Interacting with elements on a Page
		3 - Element Locator Types – ID, Names, XPath, CSS,
		4 - Element Locator precedence/best practices
		Demo: WebElement operations for textbox, buttons, radio buttons and WebTables
	*/
	@BeforeMethod
	public void beforeTest() {
			
	}	

	@AfterTest
	public void afterTest() {
		
	}
	
	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 The main() method, in Java, is the entry point for the JVM(Java Virtual Machine)
	  into the java program. JVM launches the java program by invoking the main() method.
	  
	  When Java Runtime Environment(JRE) starts, there is no object of the class present.
	  That’s why the main method has to be static so that JVM can load the class into memory and 
	  call the main methods
	*/
	
	public static void main(String[] args) {
		String practiceFormURL = "https://www.toolsqa.com/automation-practice-form/";
		
		//set webdriver.chrome.driver to define chromedriver executable filepath
		String projectBasePath = "C:\\Users\\ramparo\\eclipse-workspace\\lps-selenium-training\\";
		
		//download chrome driver from https://chromedriver.chromium.org/downloads
		System.setProperty("webdriver.chrome.driver", projectBasePath + "chromedriver.exe");
		
		//download firefox driver from https://github.com/mozilla/geckodriver/releases
		System.setProperty("webdriver.firefox.driver", projectBasePath + "geckodriver.exe");
		
		
		//ChromeOptions chromeOptions = new ChromeOptions();
		//chromeOptions.addArguments("--headless");
		
		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.navigate().to(practiceFormURL);
		
		System.out.println("Website title is " + chromeDriver.getTitle());
		System.out.println("Website URL is " + chromeDriver.getCurrentUrl());
		
		//find element by Partial Link Text
		WebElement partialLinkElement = chromeDriver.findElement(By.partialLinkText("Link Test"));
		System.out.println("Partial Link Text=" + partialLinkElement.getText());
			
		//find element by Link Text
		WebElement linkElement = chromeDriver.findElement(By.linkText("Link Test"));
		System.out.println("Link Text=" + linkElement.getText());
		
		//find element by Name
		WebElement firstNameElement = chromeDriver.findElement(By.name("firstname"));
		firstNameElement.sendKeys("First Name");
				
		//get textbox value
		System.out.println("First name textbox value is " + firstNameElement.getAttribute("value"));
		
		//find element by Name
		WebElement lastNameElement = chromeDriver.findElement(By.id("lastname"));
		lastNameElement.sendKeys("Last Name");
		
		//get textbox value
		System.out.println("Last name textbox value is " + lastNameElement.getAttribute("value"));
		
		//click button
		WebElement submitButton = chromeDriver.findElement(By.id("buttonwithclass"));
		submitButton.click();
		
		sleep(10);
		
		String radioButtonToSelect = "Female";
		String idToSelect = "";
		
		if(radioButtonToSelect.equals("Male")) {
			idToSelect = "sex-0";
		}else if(radioButtonToSelect.equals("Female")) {
			idToSelect = "sex-1";
		}
		
		WebElement radioButton = chromeDriver.findElement(By.id(idToSelect));
		radioButton.isDisplayed();  // this returns a Boolean value, if it returns true then said radio button is present on the webpage or it returns False.
		radioButton.click();
		radioButton.isSelected(); // this returns a Boolean value, if it returns true then said radio button is selected or it returns False
		
		chromeDriver.close(); // only the window that has focus is closed.
		chromeDriver.quit(); // exit the browser, end the session, tabs, pop-ups
	}

}