package main.java.com.dbyl.libarary.utils;

/**
 * This is builder pattern
 * 
 * @author young
 *
 */
public class Builder {
	String host;
	int port;
	String proxy;

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

	public Builder() {
		super();
	}
	

}
