package com.dbyl.tests;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.dbyl.libarary.listeners.ImplTestNGListener;

/**
 * This is to verify testng annotation execute
 * 
 * @author Young
 *
 */
@Listeners(ImplTestNGListener.class)
public class TestngExample {
	private int a;

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite() throws Exception {
		System.out.println("This Before Suite Method, will run one time");
	}

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		a = 2;
		System.out.println("This is beforClass method. The Value of a is: " + a);

	}

	@BeforeClass
	public void beforeClass() {
		a = 1;
		System.out.println("This is beforeClass method .The Value of a is: " + a);
	}

	@Test(enabled = true, groups = { "TestngExample",
			"The Test Group 1" }, priority = 3, description = "This is Example for failed")
	public void testExample1() {
		a = 3;
		System.out.println("This is Test  method1 .The Value of a is: " + a);
		Assert.assertTrue(a == 1);
	}

	@Test(groups = { "TestngExample", "The Test Group 2" }, description = "This is Example for PASS", priority = 2)
	public void testExample2() {
		a = 4;
		Assert.assertEquals(a/0, 0);
		System.out.println("This is Test  method2 .The Value of a is: " + a);
	}

	@Test(enabled = true, threadPoolSize = 5, invocationCount = 10)
	public void parallelTest() throws InterruptedException {
		System.out.println("Current Thread Id: " + Thread.currentThread().getId());
		Thread.sleep(1000);
	}

	/**
	 * This test will skip
	 */
	@Test(priority = 1)
	public void skipTest() {
		throw new SkipException("skip the test");
	}

	@AfterClass
	public void afterClass() {
		a = 5;
		System.out.println("This is AfterClass Method .The Value of a is: " + a);

	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod() throws InterruptedException {
		a = 6;
		Thread.sleep(3000);
		System.out.println("This is AfterMethod Method .The Value of a is: " + a);
	}

	@AfterSuite(alwaysRun = true)
	public void afterSuite() {
		System.out.println("This is after AfterSuite Method");
	}
}
