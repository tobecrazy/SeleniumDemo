package com.dbyl.tests;

import java.lang.reflect.InvocationTargetException;

import org.testng.annotations.Listeners;

import com.dbyl.libarary.pageAction.LoginPage;
import com.dbyl.libarary.utils.DriverFactory;
import com.dbyl.libarary.utils.Locator;
import com.dbyl.libarary.utils.PageFactory;
import com.dbyl.libarary.utils.TestNGListener;
@Listeners({ TestNGListener.class })
public class Test {

	@org.testng.annotations.Test
	public  void myTest() throws Exception {
	
	
		LoginPage h = null;
		try {
			h = (LoginPage) PageFactory.getPage(LoginPage.class,
					DriverFactory.getChromeDriver());
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		h.typeEmailInputBox("TEst");
		h.typePasswordInputBox("TTTTT");
		h.clickOnLoginButton();
		boolean a= h.isElementPresent(new Locator("//input"), 1);
		if(a)
		{
			System.out.print("11121231");
		}
	}


}
