package com.dbyl.tests.training.day5;


public class ThreadTest {

	public static void main(String[] args) {
		Thread thread= new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("Thread Test");
			}});
		thread.start();
		Thread1 thread1=new Thread1();
		thread1.start();
		Thread2 thread2=new Thread2();
		Thread thread3=new Thread(thread2);
		thread3.start();
	 
		
	}
	


}
