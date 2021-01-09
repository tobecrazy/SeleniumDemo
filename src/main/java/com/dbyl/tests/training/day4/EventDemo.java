package com.dbyl.tests.training.day4;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EventDemo {
	public WebDriver driver;
	String path=System.getProperty("user.dir");
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
		driver.get("file://"+path+"/data/WebElement.html");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebElement target1 = driver.findElement(By.id("fname"));
		DOMEvent(target1, "mouseover");
	}

	@AfterClass
	public void stopDriver() {
		// driver.quit();
	}

	/**
	 * For DOM Event
	 * 
	 * @author Young
	 * @param locator
	 * @param event
	 *            please refer to:
	 *            http://www.w3school.com.cn/jsref/dom_obj_event.asp
	 * 
	 */
	public void DOMEvent(WebElement element, String event) {
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String js = "var event;if (document.createEvent){event = document.createEvent(\"HTMLEvents\");event.initEvent(\""
				+ event + "\", true, false);arguments[0].dispatchEvent(event);} else {arguments[0].fireEvent(\"on"
				+ event + "\")}";
		System.out.println(js);
		jse.executeScript(js, element);
	}
}
