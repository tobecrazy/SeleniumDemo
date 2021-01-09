package com.dbyl.tests;

import com.dbyl.libarary.listeners.TestNGListener;
import com.dbyl.libarary.pageAction.NewLoginPage;
import com.dbyl.libarary.utils.DriverFactory;
import com.dbyl.libarary.utils.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

@Listeners({ TestNGListener.class })
public class TestDropList {
	String url="https://test2.5udaikuan.com/hongshan/mf/market/customer.html#/loan/product/FMP190524000027992?qrcode=AQ190524000029065";

	@org.testng.annotations.Test
	public void myTest() throws Exception {
		DriverFactory.close();
		Long currentTime=System.currentTimeMillis();
		String cString=Long.toString(currentTime);
		WebDriver driver = DriverFactory.getInstance().getFirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		WebElement e=driver.findElement(By.name("marriage"));
		String values="已婚有子女";
		jse.executeScript("arguments[0].value=\"" + values + "\"", e);

	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
//		DriverFactory.getInstance().getDriver().quit();
//		DriverFactory.close();
	}

}
