package com.swaroop.learningSelenium;

import java.util.concurrent.TimeUnit;

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

public class FourthSeleniumSessionActionsDemo {

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
//		wd = new EdgeDriver();
//		wd = new SafariDriver();

		// Load a webPage
//		wd.get("https://www.google.com/");
		
		wait = new WebDriverWait(wd, 10);

		wd.get("https://demoqa.com/buttons");

		wd.manage().window().maximize();
		
		action = new Actions(wd);

	}

	@Test
	public void validateRegularClick() {
		WebElement clickMeBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Click Me']")));
		
		action.click(clickMeBtn).perform();
		
		WebElement dynamicClickMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dynamicClickMessage")));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dynamicClickMessage")));
		Assert.assertEquals(dynamicClickMessage.getText(), "You have done a dynamic click","MEssage not correct");
		
		
	}
	
	@Test
	public void validateRightClick() {
		WebElement rightClickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#rightClickBtn")));
		
		action.contextClick(rightClickBtn).perform();
		
		WebElement rightClickMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#rightClickMessage")));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dynamicClickMessage")));
		Assert.assertEquals(rightClickMessage.getText(), "You have done a right click","MEssage not correct");
		
		
	}
	
	@Test
	public void validateDoubleClick() {
		WebElement doubleClickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#doubleClickBtn")));
		
		action.doubleClick(doubleClickBtn).perform();
		
		WebElement doubleClickMessage = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#doubleClickMessage")));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dynamicClickMessage")));
		Assert.assertEquals(doubleClickMessage.getText(), "You have done a double click","MEssage not correct");
		
		
	}
	
	@Test
	public void validateDragAndDrop() {
		wd.navigate().to("https://demoqa.com/droppable");
		WebElement dragSource = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#draggable")));
		WebElement dropTarget = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#droppable")));

		action.dragAndDrop(dragSource, dropTarget).perform();
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dynamicClickMessage")));
		Assert.assertEquals(dropTarget.getText(), "Dropped!","MEssage not correct");
		
	}
	
	@Test
	public void validateMouseHoverAction() {
		wd.navigate().to("https://demoqa.com/tool-tips");
		WebElement mouseHoverButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#toolTipButton")));
		action.moveToElement(mouseHoverButton).perform();
		
		String attributeValueForToolTip = mouseHoverButton.getAttribute("aria-describedby");
		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#dynamicClickMessage")));
		Assert.assertEquals(attributeValueForToolTip, "buttonToolTip","Attribute value not correct");
		
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
