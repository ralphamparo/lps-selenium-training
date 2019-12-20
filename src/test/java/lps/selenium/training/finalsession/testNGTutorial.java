package lps.selenium.training.finalsession;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class testNGTutorial {

    public static void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	public String baseUrl = "https://techcanvass.com/examples/webtable.html";
	String projectBasePath = "C:\\Users\\ramparo\\eclipse-workspace\\lps-selenium-training\\";

	public WebDriver driver ;

	@BeforeTest
	public void launchBrowser() {
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", projectBasePath + "chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}
	@Parameters({"company", "make", "showroomPrice"})

	@Test
	public void findWebTableRowUsingXpath(String company, String make, String showroomPrice) {

		// Verify that the "Company Name" passed from testNG param "company" is present in the table
		WebElement companyColumn = driver.findElement(By.xpath("//td[text()='" + company + "']"));
		System.out.println("Company=" + company + "is displayed." + companyColumn.isDisplayed());

		// Verify that the "Make" passed from testNG param "company" is present in the table
		WebElement makeColumn = driver.findElement(By.xpath("//td[text()='" + company + "']/parent::tr/td[text()='" + make + "']"));
		System.out.println("Company=" + make + "is displayed." + makeColumn.isDisplayed());

		// Verify that the "Make" passed from testNG param "company" is present in the table
		WebElement showroomPriceColumn = driver.findElement(By.xpath("//td[text()='" + company + "']/parent::tr/td[text()='" + showroomPrice + "']"));
		System.out.println("Showroom Price=" + showroomPrice + "is displayed." + showroomPriceColumn.isDisplayed());
	}

	@Parameters({"company", "make", "showroomPrice"})
	@Test
	public void findWebTableRowUsingLoops(String company, String make, String showroomPrice) {

		WebElement webtable = driver.findElement(By.id("t01"));
		List<WebElement> rowList = webtable.findElements(By.tagName("tr"));

		System.out.println("Number of Rows including headings:"+ rowList.size());

		boolean tableRowIsFound = false;

		//iterate each row in in the table
		for (int rowCtr=0; rowCtr < rowList.size(); rowCtr++) {
			System.out.println();
			//get all column values for each row
			List<WebElement> columnsList = rowList.get(rowCtr).findElements(By.xpath("//td"));

			String companyNameValue = columnsList.get(0).getText(); //get text from 0/first column
			String makeValue = columnsList.get(1).getText(); //get text from 1/second column
			String showroomPriceValue = columnsList.get(2).getText(); //get text from 2/second column

			if(companyNameValue.equals(company) && makeValue.equals(make) && showroomPriceValue.equals(showroomPrice)){
				System.out.println("All row values are found." + company + " " + make + " " + showroomPrice );
				tableRowIsFound = true;
				break;
			}
		}
		Assert.assertEquals(tableRowIsFound,true);
	}
	@AfterTest
	public void terminateBrowser(){
		driver.close();
		driver.quit();
	}
}