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

public class SecondSeleniumSession {
	
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
		
		wd.get("https://ca.hotels.com/login?&uurl=e3id%3Dredr%26rurl%3D%2F%3Flocale%3Den_CA%26pos%3DHCOM_CA%26siteid%3D300000002");
		
	}
	
	@Test
	public void validateButtonIsEnabled() {
		WebElement continueBtn = wd.findElement(By.id("loginFormSubmitButton"));
		WebElement emailInput = wd.findElement(By.id("loginFormEmailInput"));
		boolean isButtonEnabled = continueBtn.isEnabled();
		Assert.assertFalse(isButtonEnabled,"Button is enabled");
		
		emailInput.sendKeys("12345@email.com");
		isButtonEnabled = continueBtn.isEnabled();
		Assert.assertTrue(isButtonEnabled, "Button is enabled after entering email");
		
	}
	
	

	@AfterMethod
	public void tearDown() {
		//Used to close the current webdriver instance, close the browser
//		wd.close();
	}
}
