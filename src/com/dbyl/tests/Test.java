package com.dbyl.tests;

import com.thoughtworks.selenium.DefaultSelenium;

public class Test {

	public static void main(String[] args) {
		String url="www.baidu.com";
		String broswer="*firefox";
		DefaultSelenium selenium = new DefaultSelenium("localhost", 4444, broswer, url);
		selenium.start();
		selenium.open(url);
		selenium.windowMaximize();
	}

}
