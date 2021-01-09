package com.dbyl.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

/**
 * The Class RemoteSelenium.
 */
public class RemoteSelenium {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws MalformedURLException
	 *             the malformed URL exception
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);
		capability.setBrowserName("firefox");
		capability.setVersion("61.0.1");
		driver.get("http://www.baidu.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("selenium tobecrazy");
		driver.findElement(By.id("su")).submit();
		takeScreenShot((TakesScreenshot) driver, "123.png");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(6000);
		driver.findElement(By.partialLinkText("Selenium")).click();
		takeScreenShot((TakesScreenshot) driver, "123.png");
		Assert.assertTrue(driver.getTitle().contains("selenium tobecrazy"));
		takeScreenShot((TakesScreenshot) driver, "123.png");
		driver.get("http://www.baidu.com");
		// driver.findElement(By.linkText("糯米")).click();
		driver.findElement(By.partialLinkText("米")).click();
		Thread.sleep(6000);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		String a = (String) jse.executeScript("var title=document.title;return title");
		Assert.assertTrue(a.contains("糯米"));

		driver.get("https://www.baidu.com/search/error.html");
		Assert.assertEquals(driver.findElement(By.tagName("img")).getAttribute("alt"), "到百度首页");
		takeScreenShot((TakesScreenshot) driver, "123.png");
		driver.quit();
	}

	/**
	 * Take screen shot.
	 *
	 * @author Young
	 * @param drivername
	 *            the drivername
	 * @param path
	 *            the path
	 */
	public static void takeScreenShot(TakesScreenshot drivername, String path) {
		// this method will take screen shot ,require two parameters ,one is
		// driver name, another is file name
		String currentPath = System.getProperty("user.dir"); // get current work
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		try {
			FileUtils.copyFile(scrFile, new File(currentPath + "/" + path));
			System.out.print("===>" + currentPath + "/" + path);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
	}
}