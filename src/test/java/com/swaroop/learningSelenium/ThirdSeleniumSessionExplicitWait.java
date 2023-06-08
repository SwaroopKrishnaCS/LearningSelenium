package com.swaroop.learningSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ThirdSeleniumSessionExplicitWait {

	WebDriver wd;

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

		// Load a webPage
//		wd.get("https://www.google.com/");

		wd.get("https://www.webroot.com/us/en/home");
		wd.manage().window().maximize();

		WebElement acceptCookieBanner = wait
				.until(ExpectedConditions.visibilityOf(wd.findElement(By.id("onetrust-accept-btn-handler"))));
		acceptCookieBanner.click();
//		wd.findElement(By.id("onetrust-accept-btn-handler")).click();

	}

	@Test
	public void validateButtonIsEnabled() {

		WebElement buyNowBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Buy now'])[1]")));

		buyNowBtn.click();

		WebElement selectCountryField = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("select[name = 'billing.country']")));
		
		Select sc = new Select(selectCountryField);

		sc.selectByIndex(4);

		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "United Kingdom", "United Kingdom not selected");

		sc.selectByValue("IN");
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "India", "India not selected");

		sc.selectByVisibleText("China");
		Assert.assertEquals(sc.getFirstSelectedOption().getText(), "China", "China not selected");

	}

	@AfterMethod
	public void tearDown() {
		// Used to close the current webdriver instance, close the browser
		wd.close();
	}

}
