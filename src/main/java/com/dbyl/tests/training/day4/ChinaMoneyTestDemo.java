package com.dbyl.tests.training.day4;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ChinaMoneyTestDemo {
	public WebDriver driver;

	@BeforeClass
	public void initDriver() {
		// System.setProperty("webdriver.gecko.driver",
		// "webDriver/geckodriver");
		// driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "webDriver/chromedriver");
		driver = new ChromeDriver();
	}

	@Test()
	public void LoginTest() throws InterruptedException {
		driver.get("http://www.chinamoney.com.cn/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		actions.clickAndHold(driver.findElement(By.xpath("//a[.='市场数据']"))).perform();
		actions.clickAndHold(driver.findElement(By.xpath("//a[.='每日速递']"))).perform();
		actions.click(driver.findElement(By.xpath("//li/a[.='日报']"))).perform();
		Assert.assertTrue(isElementPresent(driver,"//tr[@class='left']//a[.='日报']"));
		 

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

	@AfterClass
	public void stopDriver() {
//		driver.quit();
	}
}
