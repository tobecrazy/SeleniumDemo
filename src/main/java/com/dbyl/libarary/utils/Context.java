package com.dbyl.libarary.utils;

public class Context {
	String host;
	int port = 80;
	String proxyHost;
	int proxyPort = 8083;
	BrowserType browserType;
	String currentURL;
	static Context context;

	public enum BrowserType {
		firefox, chrome, ie, edge, safari
	}

	public Context() {
	}

	/**
	 * This is for get instance
	 * 
	 * @return
	 */
	public static Context getInstance() {
		if (context == null) {
			synchronized (Context.class) {
				if (context == null) {
					context = new Context();
				}
			}
		}
		return context;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public int getProxyPort() {
		return proxyPort;
	}

	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	public BrowserType getBrowserType() {
		return browserType;
	}

	public void setBrowserType(BrowserType browserType) {
		this.browserType = browserType;
	}

	public String getCurrentURL() {
		return currentURL;
	}

	public void setCurrentURL(String currentURL) {
		this.currentURL = currentURL;
	}

	public void initContext() {
		this.browserType=DriverFactory.getInstance().getBrowserType();
		

	}

}
