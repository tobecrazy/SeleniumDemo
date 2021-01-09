package com.dbyl.tests;

public class Computer implements Screen {
	private String CPU;
	private int Memory;
	private String network;
	private long disk;
	private String keyboard;
	private String mouse;
	private String OS;

	public void setOnScreen(Screen screen) {
		System.out.println("Call on screen interface");
	}

	public Computer(String cPU, int memory, String network, long disk, String keyboard, String mouse, String oS) {
		super();
		CPU = cPU;
		Memory = memory;
		this.network = network;
		this.disk = disk;
		this.keyboard = keyboard;
		this.mouse = mouse;
		OS = oS;
	}

	public Computer() {
		System.out.println("init computer");
	}

	public void dowork() {
		System.out.println("Do work for computer");

	}

	public void dowork(String key) {
		System.out.println("Do work for computer" + key);

	}

	public void dowork(String key, int number) {

		System.out.println("Do work for computer" + key + number + "times");

	}

	public String getCPU() {
		return CPU;
	}

	public void setCPU(String cPU) {
		CPU = cPU;
	}

	public int getMemory() {
		return Memory;
	}

	public void setMemory(int memory) {
		Memory = memory;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
	}

	public long getDisk() {
		return disk;
	}

	public void setDisk(long disk) {
		this.disk = disk;
	}

	public String getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(String keyboard) {
		this.keyboard = keyboard;
	}

	public String getMouse() {
		return mouse;
	}

	public void setMouse(String mouse) {
		this.mouse = mouse;
	}

	public String getOS() {
		return OS;
	}

	public void setOS(String oS) {
		OS = oS;
	}

	@Override
	public void display(int h, int w) {
		System.out.println("Displayed");
	}

}
