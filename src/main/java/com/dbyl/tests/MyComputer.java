package com.dbyl.tests;

public class MyComputer extends Computer {

	public MyComputer(String cPU, int memory, String network, long disk, String keyboard, String mouse, String oS) {
		super(cPU, memory, network, disk, keyboard, mouse, oS);
	}

	public MyComputer() {
		System.out.println("init mycomputer");
	}

	@Override
	public void dowork() {
		System.out.println("Do work for mycomputer");
	}

	@Override
	public void dowork(String key) {
		System.out.println("Do work for mycomputer" + key);
	}
}
