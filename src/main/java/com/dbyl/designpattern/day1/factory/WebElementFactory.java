package main.java.com.dbyl.designpattern.day1.factory;

import main.java.com.dbyl.designpattern.day1.prodcut.IWebElement;

public class WebElementFactory implements IWebElementFactory {

	@Override
	public IWebElement generateWebElement(String key) throws Exception {
		return (IWebElement) getProduct(key);
	}

	public Object getProduct(String key) throws Exception {
		Class clazz = Class.forName(key);
		return clazz.newInstance();

	}
}
