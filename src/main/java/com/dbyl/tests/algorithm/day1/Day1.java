package com.dbyl.tests.algorithm.day1;

import org.testng.annotations.Test;

/**
 * @since 2017/7/13
 * @author young
 *
 */
public class Day1 {
	@Test
	public void TestTwoNumbers() {
		int array[] = { 2, 7, 11, 15 };
		int target = 9;
		int results[] = getTwoNumber(array, target);

		for (int re : results) {
			System.out.println(re);
		}
		String str = "pwwkew";
		int index = lengthOfLongestSubstring(str);
		System.out.println(">>>>>>>>>" + index);

		int result = reverse(1250);
		System.out.println(">>>>>>>>>" + result);

		String strReverse = reverse("-1230");
		System.out.println(">>>>>>>>>" + strReverse);

	}

	/**
	 * 
	 * Reverse digits of an integer.
	 * 
	 * Example1: x = 123, return 321 Example2: x = -123, return -321
	 * 
	 * 
	 * Note: The input is assumed to be a 32-bit signed integer. Your function
	 * should return 0 when the reversed integer overflows.
	 * 
	 * @param source
	 * @return
	 */

	public int reverse(int source) {
		int length = String.valueOf(source).length();
		int sum = 0;
		for (int i = 0; i < length; i++) {
			int a = (int) (source % Math.pow(10, length - i));
			source = source / 10;
			sum += a * Math.pow(10, length - i);
		}

		return sum;

	}

	
	/**
	 * @author young
	 * @param source
	 * @return
	 */
	public String reverse(String source) {

		char tempChar;
		char[] temp = source.toCharArray();
		for (int i = 0; i < source.length() / 2; i++) {
			tempChar = temp[i];
			temp[i] = temp[source.length() - i - 1];
			temp[source.length() - i - 1] = tempChar;
		}
		return new String(temp);
	}

	/**
	 * 
	 * Given an array of integers, return indices of the two numbers such that
	 * they add up to a specific target.
	 * 
	 * You may assume that each input would have exactly one solution, and you
	 * may not use the same element twice.
	 * 
	 * Example: Given nums = [2, 7, 11, 15], target = 9,
	 * 
	 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
	 * 
	 * @author young
	 * @param array
	 * @param target
	 * @return
	 */
	private int[] getTwoNumber(int[] array, int target) {
		int temp[] = { -1 };
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] + array[j] == target) {
					temp = new int[] { i, j };
					break;
				}
			}
		}
		return temp;
	}

	/**
	 * Examples:
	 * 
	 * Given "abcabcbb", the answer is "abc", which the length is 3.
	 * 
	 * Given "bbbbb", the answer is "b", with the length of 1.
	 * 
	 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the
	 * answer must be a substring, "pwke" is a subsequence and not a substring.
	 */
	public int lengthOfLongestSubstring(String source) {
		int max = 1;
		for (int i = 0; i < source.length() - 1; i++) {
			for (int j = i + 1; j < source.length(); j++) {
				if ((j - i) < source.length() / 2) {
					String temp = source.substring(i, j);

					if (source.substring(j, source.length()).contains(temp)) {
						if (max < temp.length()) {
							max = temp.length();
						}

					}
				}

			}
		}
		return max;
	}

}
