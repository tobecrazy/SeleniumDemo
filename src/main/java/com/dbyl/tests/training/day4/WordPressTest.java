package com.dbyl.tests.training.day4;


import static org.testng.Assert.assertEquals;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WordPressTest {

	private WebDriver driver;

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "webDriver/chromedriver");
		driver = new ChromeDriver();
		driver.get("http://192.168.1.129/wordpress/wp-login.php");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test
	public void qqMailLogin() throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Actions action = new Actions(driver);
		WebElement inputbox1 = driver.findElement(By.id("user_login"));
		inputbox1.clear();
		jse.executeScript("arguments[0].value=\"admin\"", inputbox1);
		WebElement inputbox2 = driver.findElement(By.id("user_pass"));
		inputbox2.clear();
		action.click(inputbox2).sendKeys("3edc4rfv").build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("wp-submit")).click();
		String status1 = (String) jse.executeScript("var status=document.readyState;return status");
		Assert.assertTrue(status1.contains("complete"));
		// Click 撰写新博文，input content in title and body area， then publish it.
		action.click(driver.findElement(By.linkText("撰写您的第一篇博文"))).perform();
		WebElement inputbox3 = driver.findElement(By.id("title"));
		inputbox3.click();
		jse.executeScript("arguments[0].value=\"Hello Maggie,title\"", inputbox3);
		driver.switchTo().frame("content_ifr");
		WebElement richText = driver.findElement(By.id("tinymce"));
		jse.executeScript("arguments[0].innerHTML=\"Hello Maggie,body\"", richText);
		driver.switchTo().defaultContent();
		driver.findElement(By.id("publish")).click();
		// check the content published by yourself.
		driver.get("http://192.168.1.129/wordpress");
		String status2 = (String) jse.executeScript("var status=document.readyState;return status");
		Assert.assertTrue(status2.contains("complete"));
		assertEquals(driver.findElement(By.linkText("Hello Maggie,title")).getText(), "Hello Maggie,title");
		// action.click(driver.findElement(By.linkText("Hello
		// Maggie,title"))).perform();
		takeScreenShot((TakesScreenshot) driver, "/Users/young/Downloads/1.png");
	}

	// screenshot for current page
	public static void takeScreenShot(TakesScreenshot drivername, String path) {

		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		try {
			System.out.print("save snapshot path is:" + path);
			FileUtils.copyFile(scrFile, new File(path));
		} catch (Exception e) {
			// log.error("Can't save screenshot");
			e.printStackTrace();
		} finally {
			System.out.print("screen shot finished");
		}
	}

	@AfterMethod(alwaysRun = true)
	public void aftertTestStop() {
		driver.quit();
	}
}
