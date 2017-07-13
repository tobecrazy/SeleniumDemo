package main.java.com.dbyl.algorithm.day1;

import org.testng.annotations.Test;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author young
 *
 */
public class Day1 {
	@Test
	public void TestTwoNumbers() {
		int array[] = { 2, 7, 11, 15};
		int target = 9;
		int results[] = getTwoNumber(array, target);
		
		for (int re : results) {
			System.out.println(re);
		}
	}

	/**
	 * @author young
	 * @param array
	 * @param target
	 * @return
	 */
	private int[] getTwoNumber(int[] array, int target) {
		int temp[] = {-1};
		boolean isQuit = false;
		for (int i = 0; i < array.length && !isQuit; i++) {
			for (int j = 0; j < array.length; j++) {
				if (i != j && array[i] + array[j] == target) {
					temp = new int[] { i, j };
					isQuit = true;
					break;
				}
			}
		}
		return temp;
	}

}
