package com.dbyl.tests.algorithm.day5;

import org.testng.annotations.Test;

/**
 * 
 * @author young
 *
 */
public class Day5 {
	@Test
	public void binarySearchTest() {
		int[] array = new int[] { 1, 3, 6, 7, 8, 12, 34, 56, 77, 125, 145, 176, 190, 345 };
		int key = 1;
		int index = binarySearch(array, key);
		System.out.println(String.valueOf(index));
	}

	/**
	 * @author young
	 * @param array
	 * @param key
	 * @return
	 */
	public int binarySearch(int[] array, int key) {
		int index = -1;
		int left = 0;
		int right = array.length - 1;

		if (key > array[right] || key < array[left]) {
			return index;
		}
		for (int count = 1; left <= right; count++) {
			int i = (left + right) / 2;
			int medium = array[i];
			if (medium > key) {
				right = i - 1;
			} else if (medium < key) {
				left = i + 1;
			} else {
				index = i;
				System.out.println(count);
				break;
			}
		}

		return index;

	}
}
