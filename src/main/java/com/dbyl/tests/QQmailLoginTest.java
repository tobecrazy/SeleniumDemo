package com.dbyl.tests;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.dbyl.libarary.utils.DriverFactory;

public class QQmailLoginTest {
	public WebDriver driver;

	@DataProvider(name = "getDatas")
	public Object[][] getDatas() {
		return new Object[][] { { "529079513@qq.com", "password" } };
	}

	@BeforeClass
	public void initDriver() {
		driver =DriverFactory.getInstance().getChromeDriver();
	}

	@Test(dataProvider = "getDatas")
	// @Parameters({ "userName", "password" })

	public void LoginTest(String userName, String password) throws InterruptedException {
		driver.get("https://mail.qq.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// switch to Iframe
		driver.switchTo().frame("login_frame");
		// click on account login
		WebElement accountLogin = driver.findElement(By.id("switcher_plogin"));
		accountLogin.click();

		WebElement emailInputBox = driver.findElement(By.cssSelector("input#u"));
		WebElement passwordInputBox = driver.findElement(By.cssSelector("input#p"));
		emailInputBox.click();
		emailInputBox.clear();
		emailInputBox.sendKeys(userName);
		passwordInputBox.clear();
		passwordInputBox.sendKeys(password);
		WebElement loginButton = driver.findElement(By.xpath("//a[@class='login_button']/input[@id='login_button']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", loginButton);

		// Actions actions = new Actions(driver);
		// actions.click(loginButton).perform();

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement logoutButton = wait.until( new Function<WebDriver, WebElement>() {
			@Override
			public WebElement apply(WebDriver d) {
				return driver.findElement(By.xpath("//a[@class='toptitle' and text()='退出']"));
			}

		});
		logoutButton.getText();
		Assert.assertTrue(logoutButton.isDisplayed());

	}

	@AfterClass
	public void stopDriver() {
		driver.quit();
	}
}
