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

public class SecondSeleniumSessionGetText {

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

		wd.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		wd.manage().window().maximize();

	}

	@Test
	public void validateEmailLabelText() {
		WebElement emailLabel = wd.findElement(By.xpath(" //label[text()='E-Mail Address']"));
		String emailLabelText = emailLabel.getText();
		Assert.assertEquals(emailLabelText, "E-Mail Address", "Text for Email lable not correct");

	}

	@AfterMethod
	public void tearDown() {
		// Used to close the current webdriver instance, close the browser
		wd.close();
	}
}
