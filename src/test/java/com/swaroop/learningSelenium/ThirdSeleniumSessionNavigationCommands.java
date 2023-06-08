package com.swaroop.learningSelenium;

import java.util.concurrent.TimeUnit;

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

public class ThirdSeleniumSessionNavigationCommands {

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

		wd.get("https://www.webroot.com/us/en/home");
		Assert.assertEquals(wd.getTitle(), "Virus Protection Software for All Your Devices | Webroot","Page not loaded correctly");
		wd.manage().window().maximize();

	}

	@Test
	public void validateButtonIsEnabled() {
		
		wd.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		Assert.assertEquals(wd.getTitle(), "Your Store","Page not loaded correctly");
		
		
		//Takes the webpage one step backwards in it's history
		wd.navigate().back();
		Assert.assertEquals(wd.getTitle(), "Virus Protection Software for All Your Devices | Webroot","Page not loaded correctly");
		
		//Takes the webpage one step forwards in it's history
		wd.navigate().forward();
		Assert.assertEquals(wd.getTitle(), "Your Store","Page not loaded correctly");
		
		//Refresh the current page
		wd.navigate().refresh();
		Assert.assertEquals(wd.getTitle(), "Your Store","Page not loaded correctly");
		
		
	}

	@AfterMethod
	public void tearDown() {
		// Used to close the current webdriver instance, close the browser
		wd.close();
	}

	public void sleep() {
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
