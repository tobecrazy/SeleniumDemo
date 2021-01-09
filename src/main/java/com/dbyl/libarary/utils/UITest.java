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
	LogUtils log = new LogUtils(this.getClass());

	public void init(WebDriver driver) {
		log.info("Start WebDriver");
		// init Context
		Context.getInstance().initContext();
		Context.getInstance().setCurrentURL(driver.getCurrentUrl());
		log.info("Driver Type is: " + Context.getInstance().getBrowserType());
		log.info("Driver Type is: " + Context.getInstance().getCurrentURL());
	}
	
	
}


