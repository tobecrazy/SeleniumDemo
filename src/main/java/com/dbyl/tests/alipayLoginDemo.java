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

public class alipayLoginDemo {
	private WebDriver driver;

	@Test(groups = { "edgeDriver" })
	public void edgeDriver() throws InterruptedException {
		WindowsUtils.getProgramFilesPath();
		driver =DriverFactory.getInstance().getChromeDriver();
		driver.get("https://www.alipay.com/i/indexNew.htm");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement loginbutton=driver.findElement(By.xpath("//a[@class='am-button button-login']"));
		loginbutton.click();
		driver.switchTo().frame("J_loginIframe");
		WebElement username = driver.findElement(By.id("J-input-user"));
		username.sendKeys("test");
		WebElement password=driver.findElement(By.id("password_rsainput"));
		password.sendKeys("aaaaa");

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
		isPresent = wait.until(new Function<WebDriver, WebElement>(){
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
