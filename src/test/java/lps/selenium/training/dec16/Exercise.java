package lps.selenium.training.dec16;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Exercise {
	
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
		3 - Element Locator Types � ID, Names, XPath, CSS,
		4 - Element Locator precedence/best practices
		Demo: WebElement operations for textbox, buttons, radio buttons and WebTables


	1. Open link http://automationpractice.com/index.php using Chrome or
	Firefox browser

	2. Maximize Browser

	3. Click on sign in link.

	3. Enter your email address in 'Create an account' section.

	4. Click on Create an Account button.

	5. Verify that your email address is correctly displayed in the "email" field.

	5. Enter your Personal Information, Address and Contact info.

	6. Click on Register button.

	7. Validate that user is created.

	8. Close Browser
	* */

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
	  That�s why the main method has to be static so that JVM can load the class into memory and 
	  call the main methods
	*/
	
	public static void main(String[] args) throws InterruptedException {

		//set webdriver.chrome.driver to define chromedriver executable filepath
		String projectBasePath = "C:\\Users\\ramparo\\eclipse-workspace\\lps-selenium-training\\";
		
		//download chrome driver from https://chromedriver.chromium.org/downloads
		System.setProperty("webdriver.chrome.driver", projectBasePath + "chromedriver.exe");
		
		//download firefox driver from https://github.com/mozilla/geckodriver/releases
		System.setProperty("webdriver.firefox.driver", projectBasePath + "geckodriver.exe");

		String assignmentFormURL = "http://automationpractice.com/index.php";

		ChromeDriver chromeDriver = new ChromeDriver();
		chromeDriver.manage().window().maximize();
		chromeDriver.navigate().to(assignmentFormURL);
		
		System.out.println("Website title is " + chromeDriver.getTitle());
		System.out.println("Website URL is " + chromeDriver.getCurrentUrl());

		// 2. Click on sign in link.
		WebElement linkElement = chromeDriver.findElement(By.partialLinkText("Sign in"));
		System.out.println("Link Text=" + linkElement.getText());
		linkElement.click();

		Thread.sleep(5000); // wait for 5 seconds
		// 3. Enter email address.
		WebElement emailAddress = chromeDriver.findElement(By.id("email_create"));
		emailAddress.sendKeys("abcdef@newEmail.com");

		// 3. Enter email address.
		WebElement createAnAccountButton = chromeDriver.findElement(By.id("SubmitCreate"));
		createAnAccountButton.click();

		Thread.sleep(5000); // wait for 5 seconds

		// Verify that your email address is correctly displayed in the "email" field.
		WebElement emailLabel = chromeDriver.findElement(By.xpath("//input[@value='abcdef@newEmail.com']"));
		System.out.println("emailLabel.isDisplayed()" + emailLabel.isDisplayed());

        // Select Title
        WebElement titleRadioButton = chromeDriver.findElement(By.id("id_gender1"));
        titleRadioButton.click();

        //Enter First name
        WebElement firstNameTextbox = chromeDriver.findElement(By.id("customer_firstname"));
        firstNameTextbox.sendKeys("First name");

        //Enter Last name
        WebElement lastNameTextbox = chromeDriver.findElement(By.id("customer_lastname"));
        lastNameTextbox.sendKeys("Last name");

        //Enter Password
        WebElement passwordTextbox = chromeDriver.findElement(By.id("passwd"));
        passwordTextbox.sendKeys("TestPassword");

        // create WebElement for days dropdown option, create object of Select Class
		WebElement dobDaysDropdown = chromeDriver.findElement(By.id("days"));
		Select selectDobDays = new Select(dobDaysDropdown);
        selectDobDays.selectByValue("25"); //select days dropdown option using @value attribute

        // create WebElement for months dropdown option, create object of Select Class
        WebElement dobMonthsDropdown = chromeDriver.findElement(By.id("months"));
        Select selectMonthsDoB = new Select(dobMonthsDropdown);
        selectMonthsDoB.selectByValue("3"); //select months dropdown option using @value attribute

        // create WebElement for years dropdown option, create object of Select Class
        WebElement dobYearsDropdown = chromeDriver.findElement(By.id("years"));
        Select selectYearsDoB = new Select(dobYearsDropdown);
        selectYearsDoB.selectByValue("2019"); //select years dropdown option using @value attribute

        //Enter First name - Your Address Section
        WebElement companyTextbox = chromeDriver.findElement(By.id("company"));
        companyTextbox.sendKeys("LPS");

        //Enter Address 1 - Your Address Section
        WebElement addressLine1Textbox = chromeDriver.findElement(By.id("address1"));
        addressLine1Textbox.sendKeys("Address Line 1");

        //Enter Address 2 - Your Address Section
        WebElement addressLine2Textbox = chromeDriver.findElement(By.id("address2"));
        addressLine2Textbox.sendKeys("Address Line 2");

        //Enter City - Your Address Section
        WebElement cityTextbox = chromeDriver.findElement(By.id("city"));
        cityTextbox.sendKeys("Wellington");

        // create WebElement for State dropdown, create object of Select Class
        WebElement stateDropdown = chromeDriver.findElement(By.id("id_state"));
        Select stateDoBDropdown = new Select(stateDropdown);
        stateDoBDropdown.selectByVisibleText("California"); //select years dropdown option using @value attribute

        //Enter PostCode - Your Address Section
        WebElement postCodeTextbox = chromeDriver.findElement(By.id("postcode"));
        postCodeTextbox.sendKeys("06011");

        //Enter Mobile Phone - Your Address Section
        WebElement mobilePhoneTextbox = chromeDriver.findElement(By.id("phone_mobile"));
        mobilePhoneTextbox.sendKeys("+641278971987");

        // Click Register button
        WebElement registerButton = chromeDriver.findElement(By.id("submitAccount"));
        registerButton.click();

        // Verify account is created - Check "first name and last name" value is displayed right beside logout button
        WebElement accountNameSpan = chromeDriver.findElement(By.xpath("//span[contains(text(),'First name Last name')]"));
        accountNameSpan.isDisplayed();

		chromeDriver.close(); // only the window that has focus is closed.
		chromeDriver.quit(); // exit the browser, end the session, tabs, pop-ups
	}

}