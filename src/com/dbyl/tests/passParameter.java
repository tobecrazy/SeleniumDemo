package com.dbyl.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
/**
 * This Test for verify Parameter annotation
 * @author Young
 *
 */
public class passParameter {

	/**
	 * This test before suite
	 * @param suite
	 */
	@Parameters({"suite"})
	@BeforeSuite
	public void beforeSuite(String suite)
	{
		System.out.println("before suite is "+suite);
	}
	
	@Parameters({"suite"})
	@BeforeClass
	public void beforeClass(String suite)
	{
		System.out.println("before Class can use before suite's parameter is "+suite);
	}
	/**
	 * 
	 * @param parameter1
	 * @param parameter2
	 */
	@Parameters({"parameter1","parameter2"})
	@Test(groups="parameter")
	public void parameter(String parameter1,int parameter2 )
	{
		System.out.println("parameter1 is "+parameter1 );
		System.out.println("parameter2 is "+parameter2 );
	}
}
