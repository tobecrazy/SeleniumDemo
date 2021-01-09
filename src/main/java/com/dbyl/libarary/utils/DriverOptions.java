package com.dbyl.libarary.utils;

import java.io.Serializable;

import org.openqa.selenium.WebDriver;

import com.dbyl.libarary.utils.Context.BrowserType;

public class DriverOptions implements Serializable {

	/**
	 * Crate Serial Id
	 */
	private static final long serialVersionUID = -2256159468552235965L;
	private BrowserType browserType;
	private String currentURL;
	WebDriver driver;

	public DriverOptions() {
		// TODO Auto-generated constructor stub
	}

	public synchronized BrowserType getBrowserType() {
		return browserType;
	}

	public synchronized void setBrowserType(BrowserType browserType) {
		this.browserType = browserType;
	}

	public synchronized String getCurrentURL() {
		return currentURL;
	}

	public synchronized void setCurrentURL(String currentURL) {
		this.currentURL = currentURL;
	}

	public synchronized WebDriver getDriver() {
		return driver;
	}

	public synchronized void setDriver(WebDriver driver) {
		this.driver = driver;
	}

}
