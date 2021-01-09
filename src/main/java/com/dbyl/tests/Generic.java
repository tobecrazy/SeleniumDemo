package com.dbyl.tests;

/**
 * Generic Test
 * 
 * @version 1.0
 * @author young
 *
 * @param <T>
 */
public class Generic<T> {
	private T data;

	public Generic() {
	}

	public Generic(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
