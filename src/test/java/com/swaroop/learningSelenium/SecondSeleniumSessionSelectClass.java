package com.swaroop.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondSeleniumSessionSelectClass {
	
	WebDriver wd;
	
	@BeforeMethod
	public void setup() {
		
		//Basic setup for selenium
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\ChromeDriver\\chromedriver.exe");
		
		/*Intialize Instance of WebDriver Interface.
		 * This line opens an instance of the browser
		*/
		wd =new ChromeDriver();
//		wd = new EdgeDriver();
//		wd = new SafariDriver();
		
		
		//Load a webPage
//		wd.get("https://www.google.com/");
		
		wd.get("https://www.webroot.com/us/en/cart?key=206636B2-ACE5-4D15-B267-16EC7E08A593");
		wd.manage().window().maximize();
		
	}
	
	@Test
	public void validateButtonIsEnabled() {
		WebElement selectCountryField = wd.findElement(By.cssSelector("select[name = 'billing.country']"));
		Select sc = new Select(selectCountryField);
		
		//Selecting the dropdown option by index
		sc.selectByIndex(4);
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "United Kingdom","United Kingdom not selected");
		sc.selectByValue("IN");
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "India","India not selected");
		
		sc.selectByVisibleText("China");
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "China","China not selected");
		
			
	}
	
	

	@AfterMethod
	public void tearDown() {
		//Used to close the current webdriver instance, close the browser
		wd.close();
	}
}
