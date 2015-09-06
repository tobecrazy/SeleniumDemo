/**
 * 
 */
package com.dbyl.libarary.utils;

/**
 * for remote browser bean
 * @author Young
 *
 */
public class RemoteBrowserBean {
	private String browserName;
	private String version;
	private String[] platform;
	private String hubURL;
	public String getBrowserName() {
		return browserName;
	}
	
	public RemoteBrowserBean()
	{
		this.browserName="firefox";
		this.version="39.0.3";
		this.platform=new String[]{"VISTA", "windows 7"};
		this.hubURL="http://localhost:4444/wd/hub";
		
	}
	
	public RemoteBrowserBean(String browser)
	{
		this.browserName=browser;
		this.version="42";
		this.platform=new String[]{"VISTA", "windows 7"};
		this.hubURL= "http://localhost:4444/wd/hub" ;
		
	}
	
	public RemoteBrowserBean(String browser, String hubURL) {
		this.browserName=browser;
		this.version="42";
		this.platform=new String[]{"VISTA", "windows 7"};
		this.hubURL=hubURL;
	}

	public void setBrowserName(String browserName) {
		this.browserName = browserName;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
 
	
	public String[] getPlatform() {
		return platform;
	}

	public void setPlatform(String[] platform) {
		this.platform = platform;
	}

	public String getHubURL() {
		return hubURL;
	}
	public void setHubURL(String hubURL) {
		this.hubURL = hubURL;
	}
	

}
