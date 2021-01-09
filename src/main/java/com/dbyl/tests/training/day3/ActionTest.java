package com.dbyl.tests.training.day3;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionTest {
	public WebDriver driver;

	@BeforeClass
	public void initDriver() {
		System.setProperty("webdriver.gecko.driver", "webDriver/geckodriver");
		driver = new FirefoxDriver();
		// driver=new SafariDriver();
		// System.setProperty("webdriver.chrome.driver",
		// "webDriver/chromedriver");
		// driver = new ChromeDriver();

	}

	@Test
	public void LoginTest() throws InterruptedException, AWTException {
		driver.get("https://www.baidu.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		WebElement inputBox = driver.findElement(By.id("kw"));
		inputBox.sendKeys("SELENIUM");
		WebElement search=driver.findElement(By.id("su"));
		search.click();
		actions.clickAndHold(driver.findElement(By.xpath(""))).click(driver.findElement(By.xpath("")));
//		actions.sendKeys(Keys.SHIFT).sendKeys(inputBox, "selenium").build().perform();
//		actions.contextClick(inputBox).build().perform();
		// actions.doubleClick();
		// actions.clickAndHold();
		//
		// Robot robot = new Robot();
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.delay(3000);
		// robot.keyPress(KeyEvent.VK_DOWN);
		// robot.keyRelease(KeyEvent.VK_ENTER);
		WebElement help = driver.findElement(By.xpath("//span[@id='help']/a[text()='帮助']"));
		Assert.assertTrue(help.isDisplayed());

	}

	@AfterClass
	public void stopDriver() {
		// driver.quit();
	}
}
