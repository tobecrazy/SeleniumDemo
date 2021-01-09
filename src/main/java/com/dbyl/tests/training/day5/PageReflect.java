package com.dbyl.tests.training.day5;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

public class PageReflect {
	public synchronized static Object getPage(Class<?> key, WebDriver d)
			throws ClassNotFoundException, NoSuchMethodException,
			SecurityException, IllegalArgumentException,
			InvocationTargetException {
		String pageClassName = key.getCanonicalName();
		Class<?> clazz = Class.forName(pageClassName);
		Object obj = null;
		try {
			Constructor<?> constructor = clazz.getConstructor(WebDriver.class);
			obj = constructor.newInstance(d);

		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}

}
