package com.dbyl.tests.training.day1;


/**
 * @since 2017/6/3
 * @version 1.0
 * @author young
 *
 */
public class Student {
	private String name = "Young";
	private int age = 29;

	private void showInfo() {
		System.out.println("---------------------------");
		System.out.println("My Name is " + name + " .I'm " + age + " years old");
		System.out.println("---------------------------");
	}

	private void showInfo(String name) {
		System.out.println("---------------------------");
		System.out.println("Welcome " + name + " !");
		System.out.println("---------------------------");
	}

	private void showInfo(String name, int age) {
		System.out.println("---------------------------");
		System.out.println("Welcome " + name + " !Your are " + age + " years old");
		System.out.println("---------------------------");
	}

	private void showInfo(String name, int[] scores) {
		System.out.println("---------------------------");
		System.out.println("Welcome " + name + " !");
		for (int score : scores) {
			System.out.println("Your score is " + score);
		}
		System.out.println("---------------------------");
	}
}
