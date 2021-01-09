package com.dbyl.tests.training.day5;


public class Thread1 extends Thread {

	@Override
	public void run() {
		System.out.println(this.getName());
		super.run();
	}
	
}
