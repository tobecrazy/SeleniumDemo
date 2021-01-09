package com.dbyl.tests.training.day3;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DouBanLoginTest {
	public WebDriver driver;

	@DataProvider(name="getDatas")
	public Object[][] getDatas() {
		return new Object[][] { { "user", "password" }, { "user1", "password1" } };
	}

	@BeforeClass
	public void initDriver() {
		System.setProperty("webdriver.gecko.driver", "webDriver/geckodriver");
		driver = new FirefoxDriver();
		// System.setProperty("webdriver.chrome.driver",
		// "webDriver/chromedriver");
		// WebDriver driver= new ChromeDriver();
	}

	@Test(dataProvider="getDatas")
//	@Parameters({ "userName", "password" })
	 
	public void LoginTest(String userName, String password) throws InterruptedException {
		driver.get("https://www.douban.com/accounts/login");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.switchTo().frame("");
		WebElement emailInputBox = driver.findElement(By.cssSelector("input#email"));
		WebElement passwordInputBox = driver.findElement(By.cssSelector("input#password"));
		emailInputBox.click();
		emailInputBox.clear();
		emailInputBox.sendKeys(userName);
		passwordInputBox.clear();
		passwordInputBox.sendKeys(password);
		WebElement loginButton = driver.findElement(By.className("btn-submit"));
		loginButton.click();
		WebElement profile = driver.findElement(By.xpath("//li[@class='nav-user-account']/a/span[position()=1]"));
		profile.getText();
		Assert.assertTrue(profile.getText().contains("的帐号"));

	}

	@AfterClass
	public void stopDriver() {
		driver.quit();
	}
}
