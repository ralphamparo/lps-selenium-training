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
		//submitButton.click();
		
		//sleep(10);
		
		String radioButtonOptionToSelect = "Male";
		String idToSelect = "";
		
		if(radioButtonOptionToSelect.equals("Male")) {
			idToSelect = "sex-0";
		}else if(radioButtonOptionToSelect.equals("Female")) {
			idToSelect = "sex-1";
		}
		
		WebElement radioButton= chromeDriver.findElement(By.id(idToSelect));
		if (radioButton.isDisplayed() && radioButton.isEnabled()) {
			radioButton.click();
		}
		
		radioButton.isSelected(); // this returns a Boolean value, if it returns true then said radio button is selected or it returns False
		
		chromeDriver.findElement(By.xpath("//input[@value='Female' and contains(@id,'sex')]")).click(); // select Female
		chromeDriver.switchTo().defaultContent();
		
		scrollIntoElement(chromeDriver,radioButton);
		
		//list all Years of experience radio button options
		List<WebElement> radioButtons = radioButton.findElements(By.xpath("//input[contains(@id,'exp-')]"));
		System.out.println(radioButtons);// print all radioButton element with name=exp
		
		for(int ctr = 0; ctr < radioButtons.size(); ctr++){
			System.out.println("Radio button value=" + radioButtons.get(ctr).getAttribute("value"));
		}
		
		int yearsOfExperienceValue = 7;
		
		WebElement experienceRadioButton = radioButtons.get(yearsOfExperienceValue - 1);
		
		//"Element is not clickable at point (x, y)" is a legit case, Selenium throws this exception when 
		//you attempt to click an element covered by some other element. You should avoid clicking overlapped elements.
		if (experienceRadioButton.isDisplayed() && experienceRadioButton.isEnabled()) {
			experienceRadioButton.click();
		}
		
		String profession = " Automation Tester";
		sleep(3);
		
		WebElement professionCheckbox = chromeDriver.findElement(By.xpath("//label[text()='" + profession + "']/preceding-sibling::input[1]")); // select Female
		
		if (professionCheckbox.isDisplayed() && professionCheckbox.isEnabled()) {
			professionCheckbox.click();
		}
		
		//Demonstrate this complex xpath
		//label[text()='Automation Tool']"/parent::strong/following-sibling::input[@value='Selenium IDE']
		
		WebElement automationTool = chromeDriver.findElement(By.xpath("//label[contains(text(),'Automation Tool')]"));
		
		scrollIntoElement(chromeDriver,automationTool);
		Select continentsDropdown = new Select(chromeDriver.findElement(By.id("continents")));
		
		continentsDropdown.selectByVisibleText("Antarctica");
		
		sleep(5);
		continentsDropdown.selectByValue("AUS");
		
		Select continentsDropdownWithMultiSelect = new Select(chromeDriver.findElement(By.id("continentsmultiple")));
	
		List <WebElement> elementCount = continentsDropdownWithMultiSelect.getOptions();
		 int iSize = elementCount.size();
		 
		 for(int i =0; i<iSize ; i++){
			 WebElement dropdownOption = elementCount.get(i);
			 String sValue = dropdownOption.getText();
			 
			 System.out.println("Multi select dropdown option value = " + sValue);
			 if(sValue.equals("North America")) {
				 continentsDropdownWithMultiSelect.selectByIndex(i);
			 }
		 }
		 
		chromeDriver.close(); // only the window that has focus is closed.
		chromeDriver.quit(); // exit the browser, end the session, tabs, pop-ups
	}

}