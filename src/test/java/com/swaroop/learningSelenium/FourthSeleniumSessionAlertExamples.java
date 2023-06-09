package com.swaroop.learningSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FourthSeleniumSessionAlertExamples {

	WebDriver wd;

	Actions action;
	WebDriverWait wait;

	@BeforeMethod
	public void setup() {

		// Basic setup for selenium
		System.setProperty("webdriver.chrome.driver", "C:\\Driver\\ChromeDriver\\chromedriver.exe");

		/*
		 * Intialize Instance of WebDriver Interface. This line opens an instance of the
		 * browser
		 */
		wd = new ChromeDriver();
		wait = new WebDriverWait(wd, 10);

		wd.get("https://demoqa.com/alerts");

		wd.manage().window().maximize();

		action = new Actions(wd);

	}

	@Test
	public void validateSimpleAlert() {
		WebElement alertBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#alertButton")));
		alertBtn.click();
		wd.switchTo().alert().accept();

	}

	@Test
	public void confirmationAlert() {
		WebElement alertBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#confirmButton")));
		alertBtn.click();
		wd.switchTo().alert().dismiss();

	}
	
	@Test
	public void promptAlertExample() {
		WebElement alertBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#promtButton")));
		alertBtn.click();
		Alert alert = wd.switchTo().alert();
		alert.sendKeys("Swaroop");
		alert.accept();

	}

	@AfterMethod
	public void tearDown() {
		// Used to close the current webdriver instance, close the browser
//		wd.close();
	}


}
