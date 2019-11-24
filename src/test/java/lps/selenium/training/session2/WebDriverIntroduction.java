package lps.selenium.training.session2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebDriverIntroduction {
	
	/*
	 Session 2  Training Outline:
	 a) Environment configuration
	 b) 7 Basic steps of Selenium scripting
	 c) Creating our first Selenium script with ChromeDriver(Browser & navigation commands) 
	*/
	@BeforeMethod
	public void beforeTest() {
			
	}	

	@AfterTest
	public void afterTest() {
		
	}
	
	public void sleep(int seconds) {
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
		
		//set webdriver.chrome.driver to define chromedriver executable filepath
		String projectBasePath = "C:\\Users\\ramparo\\eclipse-workspace\\lps-selenium-training\\";
		
		//download chrome driver from https://chromedriver.chromium.org/downloads
		System.setProperty("webdriver.chrome.driver", projectBasePath + "chromedriver.exe");
		
		//download firefox driver from https://github.com/mozilla/geckodriver/releases
		System.setProperty("webdriver.firefox.driver", projectBasePath + "geckodriver.exe");
		
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		
		ChromeDriver chromeDriver = new ChromeDriver(chromeOptions);
		chromeDriver.manage().window().maximize();
		chromeDriver.navigate().to("https://lps.co.nz/");
		
		System.out.print("LPS Website title is " + chromeDriver.getTitle());
		
		//Set Firefox Headless mode as TRUE
		FirefoxOptions firefoxOptions = new FirefoxOptions();
		firefoxOptions.setHeadless(true);
		
		FirefoxDriver firefoxDriver = new FirefoxDriver(firefoxOptions);
		firefoxDriver.manage().window().maximize();
		firefoxDriver.navigate().to("https://lps.co.nz/");
		
		System.out.print("LPS Website title is " + firefoxDriver.getTitle());
	}

}