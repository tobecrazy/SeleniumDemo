package com.dbyl.tests.training.day4;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class QQmailLoginTest {
	public WebDriver driver;

	@DataProvider(name = "getDatas")
	public Object[][] getDatas() {
		return new Object[][] { { "1653157218@qq.com", "xxxxxx" } };
	}

	@BeforeClass
	public void initDriver() {
		// System.setProperty("webdriver.gecko.driver",
		// "webDriver/geckodriver");
		// driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "webDriver/chromedriver");
		driver = new ChromeDriver();
	}

	@Test(dataProvider = "getDatas")
	// @Parameters({ "userName", "password" })

	public void LoginTest(String userName, String password) throws InterruptedException {
		driver.get("https://mail.qq.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// switch to Iframe
		driver.switchTo().frame("login_frame");
		driver.switchTo().defaultContent();
		
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
		WebElement logoutButton = wait.until(new ExpectedCondition<WebElement>() {
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
