package com.dbyl.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * This Test for verify Parameter annotation
 * 
 * @author Young
 *
 */
public class passParameter {

	@DataProvider(name = "data1")
	public Object[][] data() {
		return new Object[][] { { "parameter1", new Integer(316) } };

	}

	/**
	 * 
	 * @param parameter1
	 * @param parameter2
	 */
	@Test(groups = "parameter", dataProvider = "data1")
	public void parameter(String parameter1, int parameter2) {
		System.out.println("parameter1 is " + parameter1);
		System.out.println("parameter2 is " + parameter2);
	}

	@Test
	public void test1() {
		int value = fun(1, 3);
		System.out.println(value);

	}

	private int fun(int a, int b) {

		return a == b ? a : b;
	}
}
