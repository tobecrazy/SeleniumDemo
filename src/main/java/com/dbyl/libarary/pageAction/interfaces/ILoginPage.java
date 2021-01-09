package com.dbyl.libarary.pageAction.interfaces;

/**
 * This Method is for Login Page interface Resolve different version login Page
 * 
 * @version V1.0
 * @author young
 *
 */
public interface ILoginPage {
	public void typeUserName(String userName) throws Exception;

	public void typePassword(String password) throws Exception;

	public void clickOnLoginButton() throws Exception;

}
