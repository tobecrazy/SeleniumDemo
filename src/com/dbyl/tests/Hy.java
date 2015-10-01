package com.dbyl.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.dbyl.libarary.utils.DriverFactory;

public class Hy {
	private WebDriver driver;

	@Test(groups = { "edgeDriver" })
	public void edgeDriver() throws InterruptedException {
		WindowsUtils.getProgramFilesPath();
		driver =DriverFactory.getEDGEDriver();
		driver.get("https://www.baidu.com");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// 打开
		WebElement inputBox =driver.findElement(By.id("kw"));
		inputBox.sendKeys("edge browser");
		By searchBy= By.id("su");
		Thread.sleep(3000);
		if (isElementPresent(driver, searchBy))
		{
			driver.findElement(searchBy).click();
		}
		System.out.println(driver.getTitle());
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.quit();
		 

	}

	/**
	 * @author Young
	 * @param driver
	 * @param by
	 * @return
	 */
	public static boolean isElementPresent(WebDriver driver, final By by) {

		boolean isPresent = false;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		isPresent = wait.until(new ExpectedCondition<WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return d.findElement(by);
			}
		}).isDisplayed();
		return isPresent;
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
