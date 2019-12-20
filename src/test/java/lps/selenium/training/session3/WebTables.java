package lps.selenium.training.session3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTables {
	
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

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void scrollIntoElement(WebDriver driver, WebElement element) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	public static void scrollIntoDropdownElement(WebDriver driver, Select dropdown) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView()", dropdown);
	}
	/*
	 The main() method, in Java, is the entry point for the JVM(Java Virtual Machine)
	  into the java program. JVM launches the java program by invoking the main() method.
	  
	  When Java Runtime Environment(JRE) starts, there is no object of the class present.
	  That’s why the main method has to be static so that JVM can load the class into memory and 
	  call the main methods
	*/
	
	public static void main(String[] args) {
		//navigate to practice table site - http://toolsqa.com/automation-practice-table/
		
		String practiceFormURL = "http://toolsqa.com/automation-practice-table/";
		
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
		 
		chromeDriver.close(); // only the window that has focus is closed.
		chromeDriver.quit(); // exit the browser, end the session, tabs, pop-ups
	}

}