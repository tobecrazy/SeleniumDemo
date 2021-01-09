package com.dbyl.tests;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.dbyl.libarary.utils.DriverFactory;

public class CCBSoftPadDemo {
	private WebDriver driver;

	@Test(groups = { "edgeDriver" })
	public void edgeDriver() throws InterruptedException {
		WindowsUtils.getProgramFilesPath();
		driver =DriverFactory.getInstance().getFirefoxDriver();
		driver.get("https://ibsbjstar.ccb.com.cn/app/V5/CN/STY1/login.jsp");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 
		driver.switchTo().frame("fclogin");
		WebElement softKeyPad = driver.findElement(By.id("img_id"));
		softKeyPad.click();
		WebElement t=driver.findElement(By.xpath("//input[@value='t']"));
		WebElement e=driver.findElement(By.xpath("//input[@value='e']"));
		WebElement s=driver.findElement(By.xpath("//input[@value='s']"));
		t.click();
		e.click();
		s.click();
		t.click();
		WebElement confirmButton=driver.findElement(By.name("button12"));
		confirmButton.click();

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
		isPresent = wait.until( new Function<WebDriver, WebElement>() {
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
