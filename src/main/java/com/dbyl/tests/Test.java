package main.java.com.dbyl.tests;

import java.lang.reflect.InvocationTargetException;

import org.testng.annotations.Listeners;

import main.java.com.dbyl.libarary.listeners.TestNGListener;
import main.java.com.dbyl.libarary.pageAction.NewLoginPage;
import main.java.com.dbyl.libarary.utils.DriverFactory;
import main.java.com.dbyl.libarary.utils.Locator;
import main.java.com.dbyl.libarary.utils.PageFactory;

@Listeners({ TestNGListener.class })
public class Test {

	@org.testng.annotations.Test
	public void myTest() throws Exception {

		NewLoginPage h = null;
		try {
			h = (NewLoginPage) PageFactory.getPage(NewLoginPage.class, DriverFactory.getInstance().getChromeDriver());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		h.typeUserName("TEst");
		h.typePassword("TTTTT");
		h.clickOnLoginButton();
		boolean a = h.isElementPresent(new Locator("//input"), 1);
		if (a) {
			System.out.print("11121231");
		}
		DriverFactory.getInstance().getDriver().quit();
	}

}
