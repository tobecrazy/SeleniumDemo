package com.dbyl.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dbyl.libarary.utils.RetryListener;

public class Case1 {

	@DataProvider
	public Object[][] testData1() {
		return new Object[][] { { 1, 2, 3 }, { 1, 2, 4 }, { 1, 3, 4 },
				{ -1, 3, 2 } };
	}

	@DataProvider
	public Object[][] testData2() {
		return new Object[][] { { 5, 2, 3 }, { 1, 2, 4 }, { 1, -3, 4 },
				{ 6, 3, 2 } };
	}

	public static int add(int a, int b) {
		return a + b;
	}

	public static int minus(int a, int b) {
		return a - b;
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("This is Before Class");
	}

	@Test(groups = { "add" }, dataProvider = "testData1")
	public void addTest(int a, int b, int c) {
		System.out.println("This is test add method.  " + a + " + " + b + " = "
				+ c);
		Assert.assertEquals(add(a, b), c);
	}

	@Test(groups = { "minus" }, dataProvider = "testData2")
	public void minusTest(int a, int b, int c) {
		System.out.println("This is test minus method.  " + a + " - " + b
				+ " = " + c);
		Assert.assertEquals(minus(a, b), c);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This is Before Method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("This is After Method");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("This is After Class");
	}
}
