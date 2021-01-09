package com.dbyl.libarary.utils;

import com.dbyl.libarary.utils.Context.BrowserType;

/**
 * This is builder pattern
 * 
 * @author young
 *
 */
public class DriverFlags {

	private BrowserType browserType;
	private String host;
	private int port;
	private String proxy;


	public static class Builder {

		private BrowserType browserTyp;
		private String host;
		private int port;
		private String proxy;

		public BrowserType getBrowserTyp() {
			return browserTyp;
		}

		public Builder setBrowserTyp(BrowserType browserTyp) {
			this.browserTyp = browserTyp;
			return this;
		}

		public String getHost() {
			return host;
		}

		public Builder setHost(String host) {
			this.host = host;
			return this;
		}

		public int getPort() {
			return port;
		}

		public Builder setPort(int port) {
			this.port = port;
			return this;
		}

		public String getProxy() {
			return proxy;
		}

		public Builder setProxy(String proxy) {
			this.proxy = proxy;
			return this;
		}

		public DriverFlags build() {

			return new DriverFlags(this);

		}

	}

	/**
	 * 
	 * @param browserType
	 * @param host
	 * @param port
	 * @param proxy
	 */
	public DriverFlags(BrowserType browserType, String host, int port, String proxy) {
		this.browserType = browserType;
		this.host = host;
		this.port = port;
		this.proxy = proxy;
	}

	public DriverFlags() {
		super();
	}

	public DriverFlags(Builder builder) {
		this.browserType = builder.getBrowserTyp();
		this.host = builder.getHost();
		this.port = builder.getPort();
		this.proxy = builder.getProxy();
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

	public String getProxy() {
		return proxy;
	}

	public void setProxy(String proxy) {
		this.proxy = proxy;
	}

	public BrowserType getBrowserType() {
		return browserType;
	}

	public void setBrowserType(BrowserType browserType) {
		this.browserType = browserType;
	}

}
