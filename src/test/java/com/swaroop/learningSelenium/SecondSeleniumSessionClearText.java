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

public class SecondSeleniumSessionClearText {

	WebDriver wd;

	@BeforeMethod
	public void setup() {

		// Basic setup for selenium
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\ChromeDriver\\chromedriver.exe");

		/*
		 * Intialize Instance of WebDriver Interface. This line opens an instance of the
		 * browser
		 */
		wd = new ChromeDriver();
//		wd = new EdgeDriver();
//		wd = new SafariDriver();

		// Load a webPage
//		wd.get("https://www.google.com/");

		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=information/contact");
		wd.manage().window().maximize();

	}

	@Test
	public void validateTextIsClearedFromInputField() {
		WebElement nameInput = wd.findElement(By.cssSelector("#input-name"));
		WebElement emailInput = wd.findElement(By.cssSelector("#input-email"));
		WebElement enquiryInput = wd.findElement(By.cssSelector("#input-enquiry"));

		nameInput.sendKeys("Tom");
		emailInput.sendKeys("tom@email.com");
		enquiryInput.sendKeys("Testing Something");

		nameInput.clear();
		emailInput.clear();
		enquiryInput.clear();

	}

	@AfterMethod
	public void tearDown() {
		// Used to close the current webdriver instance, close the browser
		wd.close();
	}
}
