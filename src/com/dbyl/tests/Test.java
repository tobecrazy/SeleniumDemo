package com.dbyl.tests;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.dbyl.libarary.pageAction.HomePage;
import com.dbyl.libarary.pageAction.LoginPage;
import com.dbyl.libarary.utils.DriverFactory;
import com.dbyl.libarary.utils.PageFactory;

public class Test {

	public static void main(String[] args) throws Exception {
		LoginPage h = null;
		try {
			h = (LoginPage) PageFactory.getPage(LoginPage.class,DriverFactory.getChromeDriver());
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		h.typeEmailInputBox("TEst");
	}

}
