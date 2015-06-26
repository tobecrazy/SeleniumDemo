/**
 * 
 */
package com.dbyl.libarary.utils;

import org.openqa.selenium.WebDriver;

/**
 * @author Young
 *
 */
public class UITest {
	WebDriver driver;
	Log log=new Log(this.getClass());

	public WebDriver getDriver() {
		return driver;
	}

	/**
	 * init test case
	 * 
	 * @param driver
	 */
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public void init(WebDriver driver) {
		log.info("Start WebDriver");
		setDriver(driver);
	}

	/**
	 * stop webdriver
	 * 
	 * @param driver
	 */
	public void stop() {
		log.info("Stop WebDriver");
		driver.quit();

	}

}
