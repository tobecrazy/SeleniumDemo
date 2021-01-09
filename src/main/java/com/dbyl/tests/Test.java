package com.dbyl.tests;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;

import com.dbyl.libarary.listeners.TestNGListener;
import com.dbyl.libarary.pageAction.NewLoginPage;
import com.dbyl.libarary.utils.Context;
import com.dbyl.libarary.utils.DriverFactory;
import com.dbyl.libarary.utils.Locator;
import com.dbyl.libarary.utils.PageFactory;

@Listeners({ TestNGListener.class })
public class Test {

	@org.testng.annotations.Test
	public void myTest() throws Exception {
		DriverFactory.close();
		Long currentTime=System.currentTimeMillis();
		String cString=Long.toString(currentTime);
		WebDriver driver = DriverFactory.getInstance().getFirefoxDriver();
		NewLoginPage h = null;
		try {
			h = (NewLoginPage) PageFactory.getPage(NewLoginPage.class, driver);
			// Context.getInstance().initContext();
			// Context.getInstance().setCurrentURL(driver.getCurrentUrl());

		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		h.typeUserName("TEst");
		h.typePassword("TTTTT");
		h.clickOnLoginButton();
//		boolean a = h.isElementPresent(new Locator("//input"), 1);
//		if (a) {
//			System.out.print("11121231");
//		}

	}

	@AfterMethod(alwaysRun = true)
	public void afterTest() {
		DriverFactory.getInstance().getDriver().quit();
		DriverFactory.close();
	}

}
