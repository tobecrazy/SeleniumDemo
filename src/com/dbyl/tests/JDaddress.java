package com.dbyl.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.dbyl.libarary.utils.DriverFactory;

public class JDaddress {
	private WebDriver driver;

	@Test(groups = { "JDaddress" })
	public void testJD() throws InterruptedException {
		WindowsUtils.getProgramFilesPath();
		driver =DriverFactory.getChromeDriver();  // DriverFactory.getRemoteDriver(new RemoteBrowserBean("chrome"));
		driver.get("http://item.jd.com/1217499.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		// 打开
		isElementPresent(driver, "//div[@id='store-selector']//div");

		Actions actions = new Actions(driver);
		actions.clickAndHold(
				driver.findElement(By.xpath("//div[@id='store-selector']//div")))
				.perform();
		// 选择
		driver.findElement(
				By.xpath("//div[@id=\"JD-stock\"]/div[@class=\"mt\"]//li[1]/a"))
				.click();
		driver.findElement(By.linkText("上海")).click();
		driver.findElement(
				By.xpath("//div[@id=\"JD-stock\"]/div[@class=\"mt\"]//li[2]/a"))
				.click();
		driver.findElement(By.linkText("长宁区")).click();
		driver.findElement(
				By.xpath("//div[@id=\"JD-stock\"]/div[@class=\"mt\"]//li[3]/a"))
				.click();
		driver.findElement(By.linkText("中环外环之间")).click();

		Assert.assertTrue(
				driver.findElement(
						By.xpath("//div[@id='store-selector']//div[@title]"))
						.getText().equals("上海长宁区中环外环之间"),
				"can't fond key words");

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
