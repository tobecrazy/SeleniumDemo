package com.dbyl.libarary.utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

public class PageFactory {
	static Log log=new Log(PageFactory.class);
	public synchronized static Object getPage(Class<?> key,WebDriver d)
			throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		String test = key.getCanonicalName();
		log.info(test);
		Class<?> clazz = Class.forName(test);
		Object obj = null;
		try {
		    Constructor<?> constructor = clazz.getConstructor(WebDriver.class);
			obj = constructor.newInstance(d);
			 

		} catch (InstantiationException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return obj;

	}

}
