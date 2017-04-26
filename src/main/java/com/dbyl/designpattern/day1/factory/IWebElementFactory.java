package main.java.com.dbyl.designpattern.day1.factory;

import main.java.com.dbyl.designpattern.day1.prodcut.IWebElement;

/**
 * 
 * @author young
 *
 */
public interface IWebElementFactory {

	public IWebElement generateWebElement(String key) throws Exception;

}
