package com.dbyl.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Key;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.dbyl.libarary.utils.DriverFactory;

public class baiduEditor {
	private WebDriver driver;

	@Test(groups = { "baiduEditor" })
	public void testJD() throws InterruptedException, Exception {
		WindowsUtils.getProgramFilesPath();
		driver = DriverFactory.getFirefoxDriver(); // DriverFactory.getRemoteDriver(new
													// RemoteBrowserBean("chrome"));
		driver.get("http://music.baidu.com/pc/spec/download9117/BaiduMusic-12345617.exe");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
	 
		
		// login
//		driver.findElement(By.cssSelector("div>input#loginemail")).sendKeys(
//				"tobecrazy@yeah.net");
//		driver.findElement(By.cssSelector("div>input#loginpassword")).sendKeys(
//				"3edc1qaz5tgb");
//		driver.findElement(By.cssSelector("button#loginsubmit")).submit();
//		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//
//		// verify login successful
//		Assert.assertTrue(isElementPresent(driver, "//li/a[.='文字']"));
//		// go to text page
//		driver.findElement(By.xpath("//li/a[.='文字']")).click();
//		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//		driver.findElement(By.cssSelector("div.blogTittle>input[type='text']"))
//				.sendKeys("Selenium");
//		driver.switchTo().frame("baidu_editor_0");
//		
//		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement editor = driver.findElement(By.tagName("body"));
//		js.executeScript(
//				"arguments[0].innerHTML = '<h1>Selenium Test </h1>I love Selenium <br> this article Post By Selenium WebDriver<br><h2>Create By Young</h2>'",
//				editor);
//		driver.switchTo().defaultContent();
//		driver.findElement(By.cssSelector("button>span.ztag")).click();
	}

	public static boolean isElementPresent(WebDriver driver, final String xpath) {

		boolean isPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		isPresent = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(By.xpath(xpath));
			}
		}).isDisplayed();
		return isPresent;
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		//driver.quit();
	}

}
