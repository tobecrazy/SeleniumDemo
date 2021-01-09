package com.dbyl.tests.training.day4;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class JDAddress {
	public WebDriver driver;

	@BeforeClass
	public void initDriver() {
		System.setProperty("webdriver.gecko.driver", "webDriver/geckodriver");
		driver = new FirefoxDriver();
		// System.setProperty("webdriver.chrome.driver",
		// "webDriver/chromedriver");
		// driver = new ChromeDriver();
	}

	@Test()
	public void LoginTest() throws InterruptedException {
		driver.get("https://item.jd.com/3335215.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		// 打开
		isElementPresent(driver, "//div[@id='store-selector']//div");
		
		Actions actions = new Actions(driver);
		actions.clickAndHold(driver.findElement(By.xpath("//div[@id='store-selector']//div"))).perform();
		 
		// 选择
		driver.findElement(By.xpath("//div[@id=\"JD-stock\"]/div[@class=\"mt\"]//li[1]/a")).click();
		driver.findElement(By.linkText("上海")).click();
		driver.findElement(By.xpath("//div[@id=\"JD-stock\"]/div[@class=\"mt\"]//li[2]/a")).click();
		driver.findElement(By.linkText("浦东新区")).click();
		driver.findElement(By.xpath("//div[@id=\"JD-stock\"]/div[@class=\"mt\"]//li[3]/a")).click();
		driver.findElement(By.linkText("张江镇")).click();
		Thread.sleep(3000);
		WebElement addBar = driver.findElement(By.xpath("//div[@id='store-selector']//div[@title]"));
		System.out.println(addBar.getText());
		Assert.assertTrue(addBar.getText().equals("上海浦东新区张江镇"), "can't fond key words");

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
		driver.quit();
	}
}
