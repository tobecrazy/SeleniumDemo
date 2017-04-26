package main.java.com.dbyl.designpattern.day1.factory;

import main.java.com.dbyl.designpattern.day1.prodcut.IWebDriver;

/**
 * DriverFactory Interface 工厂接口
 * 
 * @author young
 *
 */
public interface IDriverFactory {
	public IWebDriver generateDriver(String key) throws Exception;
}
