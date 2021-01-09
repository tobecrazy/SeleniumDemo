package com.dbyl.tests.training.day3;


import java.awt.AWTException;
import java.awt.Event;
import java.awt.Robot;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RichTextDemo {

	WebDriver driver;

	@BeforeMethod
	public void beforeInitDriver() {
		System.setProperty("webdriver.gecko.driver", "webDriver/geckodriver");
		driver = new FirefoxDriver();
	}

	@Test
	public void test() throws InterruptedException, AWTException {

		driver.get("http://bj.96weixin.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String status=(String) jse.executeScript("var status=document.readyState;return status");
		Assert.assertTrue(status.contains("complete"));
		WebElement iframe = driver.findElement(By.id("ueditor_0"));
		driver.switchTo().frame(iframe);
		WebElement richTextBox = driver.findElement(By.tagName("body"));
		
		jse.executeScript(
				"arguments[0].innerHTML='<h1>Selenium Test </h1>I love Selenium <br> this article Post By Selenium WebDriver<br><h2>Create By Young</h2>'",
				richTextBox);
		richTextBox.click();
		Robot robot =new Robot();
		robot.keyPress(Event.DELETE);
		robot.keyPress(Event.DELETE);
	    robot.delay(2000);
		Thread.sleep(5000);
		String result = (String) jse.executeScript("var result= arguments[0].innerHTML;return result", richTextBox);
		Assert.assertEquals(
				"<h1>Selenium Test </h1>I love Selenium <br> this article Post By Selenium WebDriver<br><h2>Create By Young</h2>",
				result);

	}

	@AfterMethod
	public void afterTestStopDriver() {
		driver.quit();
	}

}
