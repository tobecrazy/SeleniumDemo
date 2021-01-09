package com.dbyl.tests.training.day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTest {
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
		driver.get("https://test-rl-1.shopkeepapp.com/ipad-layout");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		WebElement storeName=driver.findElement(By.id("store_name"));
		storeName.sendKeys("test-rl-1");
		WebElement userName=driver.findElement(By.id("login"));
		userName.sendKeys("richard_li@shopkeep.com");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("RLpassword123");
		
		WebElement submit=driver.findElement(By.id("submit"));
		submit.click();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));
		driver.get("https://www.shopkeepapp.com/ipad-layout");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		WebElement search=driver.findElement(By.id("item-search-input"));
		search.sendKeys("donut");
		
		WebElement describtion=driver.findElement(By.xpath("//*[@id='results']//span[@class='description']"));
		Assert.assertTrue(describtion.getText().contains("Donut"));
		
	}
}
