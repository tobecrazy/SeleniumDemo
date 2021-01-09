package com.dbyl.tests.training.day3;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestngDemo {
	@DataProvider(name = "data")
	public Object[][] getData() {
		return new Object[][] { { "FF", "admin", "admin" }, { "chrome", "Jack", "pwd" } };
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}

	@Test(dataProvider = "data")
	public void demo(String browser, String username, String password) {
		System.out.println(browser + "-----" + username + "-----" + password);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}

	@AfterClass
	public void afterClass() {

		System.out.println("After Class");

	}
}
