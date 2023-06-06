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

public class FirstSeleniumSession {
	
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
		
		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
	}
	
	@Test(invocationCount = 10)
	public void validateLogin() {
		//Find the elements in DOM
//		WebElement emailInput = wd.findElement(By.cssSelector("[id^='input-e']"));
//		WebElement passwordInput = wd.findElement(By.cssSelector("[id^='input-p']"));
//		WebElement loginBtn = wd.findElement(By.cssSelector("input[value = 'Login']"));
		
		WebElement emailInput = wd.findElement(By.xpath("//input[@name = 'email']"));
		WebElement passwordInput = wd.findElement(By.xpath("//input[@name = 'password']"));
		WebElement loginBtn = wd.findElement(By.xpath("//input[@value= 'Login']"));
		
		//perform actions
		//enter text in an input field
		emailInput.sendKeys("tony@email.com");
		passwordInput.sendKeys("Password1");
		//click on the login button
		loginBtn.click();
		
		System.out.println(wd.getTitle());
		Assert.assertEquals(wd.getTitle(),"My Account","You are not on Correct Page");
	}

	@AfterMethod
	public void tearDown() {
		//Used to close the current webdriver instance, close the browser
		wd.close();
	}
}
