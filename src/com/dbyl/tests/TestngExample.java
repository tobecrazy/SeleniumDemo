package com.dbyl.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 * This is to verify testng annotation execute 
 * @author Young
 *
 */
public class TestngExample {
	private int a;

	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() {
		a = 2;
		System.out.println("This is beforeMethod method. The Value of a is: "
				+ a);
	}

	@BeforeClass
	public void beforeClass() {
		a = 1;
		System.out.println("This is beforeClass method .The Value of a is: "
				+ a);
	}

	@Test(groups = "TestngExample")
	public void testExample1() {
		a = 3;
		System.out.println("This is Test  method1 .The Value of a is: " + a);
	}

	@Test(groups = "TestngExample")
	public void testExample2() {
		a = 4;
		System.out.println("This is Test  method2 .The Value of a is: " + a);
	}

	@AfterClass
	public void afterClass() {
		a = 5;
		System.out.println("This is AfterClass Method .The Value of a is: " + a);

	}
	
	@AfterMethod
	public void afterMethod()
	{
		a = 6;
		System.out.println("This is AfterMethod Method .The Value of a is: " + a);
	}

}
