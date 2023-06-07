package com.swaroop.learningSelenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SecondSeleniumSessionIsSelected {
	
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
		
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
	}
	
	@Test
	public void validateButtonIsEnabled() {
		WebElement radioButtonNo = wd.findElement(By.xpath("( //input[@name = 'newsletter'])[2]"));
		boolean isNoButtonSelected = radioButtonNo.isSelected();
		Assert.assertTrue(isNoButtonSelected, "Radio Button No is not selected");
		
	}
	
	

	@AfterMethod
	public void tearDown() {
		//Used to close the current webdriver instance, close the browser
		wd.close();
	}
}
