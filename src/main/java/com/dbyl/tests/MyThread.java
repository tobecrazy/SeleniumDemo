package com.dbyl.tests;

public class MyThread extends Thread {
	public String name;
	public boolean isRun = true;

	public MyThread(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		while (isRun) {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(100);
					int[] array = new int[] { 1, 3, 4, 2, 0 };
					// BubbleSort(array);
					SelectionSort(array);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Thread number " + i + " " + this.name);
			}

		}

	}

	public void SelectionSort(int[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			int minIndex = i;
			int temp;
			for (int j = i; j < array.length; j++) {
				if (array[minIndex] > array[j]) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				temp = array[i];
				array[i] = array[minIndex];
				array[minIndex] = temp;
			}
		}
		for (int num : array) {
			System.out.println("---" + num);
		}
	}

	public void BubbleSort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				int temp = 0;
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		for (int num : array) {
			System.out.println("---" + num);
		}
	}

}
