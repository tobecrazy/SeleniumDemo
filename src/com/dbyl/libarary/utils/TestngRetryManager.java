package com.dbyl.libarary.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestngRetryManager implements IRetryAnalyzer {

	public TestngRetryManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		return false;
	}

}
