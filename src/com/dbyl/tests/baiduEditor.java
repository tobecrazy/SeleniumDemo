package com.dbyl.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.dbyl.libarary.utils.DriverFactory;
import com.dbyl.libarary.utils.RemoteBrowserBean;

public class baiduEditor {
	private WebDriver driver;

	@Test(groups = { "baiduEditor" })
	public void testJD() throws InterruptedException, Exception {
		WindowsUtils.getProgramFilesPath();
		RemoteBrowserBean remoteBrowserBean = new RemoteBrowserBean("firefox", "http://192.168.1.105:4444/wd/hub");
		driver =  DriverFactory.getRemoteDriver(remoteBrowserBean);
		driver.get("http://www.w3school.com.cn/tiy/t.asp?f=html5_form_autocomplete");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.switchTo().frame("i");
		WebElement userNameInputBox = driver.findElement(By.xpath("//input[@name='fname']"));
		userNameInputBox.sendKeys("Test");

		Assert.assertEquals(userNameInputBox.getAttribute("value"), "Test");
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
		driver.quit();
	}

}
