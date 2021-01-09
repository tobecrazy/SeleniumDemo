package com.dbyl.tests.training.day3;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindElementTest {

	@Test
	public void test() throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "webDriver/geckodriver");
		WebDriver driver = new FirefoxDriver();
		// WebDriver driver= new ChromeDriver();
		driver.get("http://www.baidu.com");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		// driver.findElement(By.id("kw")).sendKeys("selenium tobecrazy");
		// driver.findElement(By.className("s_ipt")).sendKeys("selenium
		// tobecrazy");
		// driver.findElement(By.name("wd")).sendKeys("selenium tobecrazy");
		// driver.findElement(By.cssSelector("input#kw")).sendKeys("selenium
		// tobecrazy");
		driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("selenium tobecrazy");
		driver.findElement(By.id("su")).submit();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(6000);
		driver.findElement(By.linkText("")).click();
		Assert.assertTrue(driver.getTitle().contains("selenium tobecrazy"));
		driver.get("http://www.baidu.com");
		// driver.findElement(By.linkText("糯米")).click();
		driver.findElement(By.partialLinkText("米")).click();
		Thread.sleep(6000);
		JavascriptExecutor jse= (JavascriptExecutor) driver;
		String a=(String) jse.executeScript("var title=document.title;return title");
		Assert.assertTrue(a.contains("糯米"));
		
		driver.get("https://www.baidu.com/search/error.html");
		Assert.assertEquals(driver.findElement(By.tagName("img")).getAttribute("alt"), "到百度首页");
		driver.quit();
	}

}
