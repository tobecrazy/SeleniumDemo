package com.dbyl.tests.training.day1;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.testng.annotations.Test;

public class TestPrivateMethodAndVariable {
	Class clazz = Student.class;

	@Test
	public void TestPriavteMethodWithoutParameter()
			throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, ClassNotFoundException {
		Class clazz = Class.forName("com.dbyl.tests.training.day1.Student");
		
		Method showInfo = clazz.getDeclaredMethod("showInfo", null);
		showInfo.setAccessible(true);
		Object obj = clazz.newInstance();
		showInfo.invoke(obj, null);
	}

	@Test
	public void TestPriavteMethodWithOneParameter() throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object obj = clazz.newInstance();
		Method showInfo = clazz.getDeclaredMethod("showInfo", String.class);
		showInfo.setAccessible(true);
		showInfo.invoke(obj, "Jason");
	}

	@Test
	public void TestPriavteMethodWithTwoParameter() throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = new Student().getClass();
		Object obj = clazz.newInstance();
		Method showInfo = clazz.getDeclaredMethod("showInfo", String.class, int.class);
		showInfo.setAccessible(true);
		showInfo.invoke(obj, "Jason", 23);
	}

	@Test
	public void TestPriavteMethodWithArrayParameter() throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Object obj = clazz.newInstance();
		Method showInfo = clazz.getDeclaredMethod("showInfo", String.class, int[].class);
		showInfo.setAccessible(true);
		showInfo.invoke(obj, "Jack", new int[] { 87, 98 });
	}

	@Test
	public void TestPriavteVariableWithoutParameter()
			throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		Object obj = clazz.newInstance();
		Field name = clazz.getDeclaredField("name");
		name.setAccessible(true);
		name.set(obj, "Selly");
		Method showInfo = clazz.getDeclaredMethod("showInfo", null);
		showInfo.setAccessible(true);
		showInfo.invoke(obj, null);
	}
}
