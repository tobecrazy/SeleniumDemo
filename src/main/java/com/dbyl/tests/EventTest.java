package com.dbyl.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dbyl.libarary.listeners.ImplTestNGListener;
import com.dbyl.libarary.utils.BasePage;
import com.dbyl.libarary.utils.DriverFactory;
import com.dbyl.libarary.utils.Locator;
import com.dbyl.libarary.utils.RemoteBrowserBean;

/**
 * The Class EventTest.
 */
@Listeners(ImplTestNGListener.class)
public class EventTest extends BasePage {

	/**
	 * Instantiates a new event test.
	 *
	 * @param driver
	 *            the driver
	 * @throws Exception
	 *             the exception
	 */
	protected EventTest(WebDriver driver) throws Exception {
		super(driver);
		driver.get("http://www.w3school.com.cn/jsref/event_onblur.asp");
	}

	/**
	 * Sets the value.
	 *
	 * @param msg
	 *            the new value
	 * @throws Exception
	 *             the exception
	 */
	public void setValue(String msg) throws Exception {
		Locator input = new Locator("//input[@id='fname']");
		type(input, msg);
		Thread.sleep(10000);
		DOMEvent(input, "blur");

	}

	/**
	 * Run test.
	 *
	 * @throws Exception
	 *             the exception
	 */
	@Test(groups = "loginTest")
	public void runTest() throws Exception {
		RemoteBrowserBean remoteBrowserBean = new RemoteBrowserBean();
		WebDriver driver = DriverFactory.getInstance().getRemoteDriver(remoteBrowserBean);
		EventTest c = new EventTest(driver);
		c.setValue("abcde");

	}
}
