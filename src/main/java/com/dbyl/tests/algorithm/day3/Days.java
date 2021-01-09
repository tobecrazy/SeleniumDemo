package com.dbyl.tests.algorithm.day3;

import org.testng.annotations.Test;

/**
 * 
 * @author I321533 Reverse digits of an integer.
 * 
 *         Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 *         click to show spoilers.
 * 
 *         Have you thought about this? Here are some good questions to ask
 *         before coding. Bonus points for you if you have already thought
 *         through this!
 * 
 *         If the integer's last digit is 0, what should the output be? ie,
 *         cases such as 10, 100.
 * 
 *         Did you notice that the reversed integer might overflow? Assume the
 *         input is a 32-bit integer, then the reverse of 1000000003 overflows.
 *         How should you handle such cases?
 * 
 *         For the purpose of this problem, assume that your function returns 0
 *         when the reversed integer overflows.
 * 
 *         Note: The input is assumed to be a 32-bit signed integer. Your
 *         function should return 0 when the reversed integer overflows.
 *
 */
public class Days {

	int a = 567;

	@Test
	public void testReverseInteger() {
		System.out.println(java.lang.Integer.MAX_VALUE / 2);
		System.out.println(java.lang.Integer.MIN_VALUE);
		System.out.println(reverse(a));
	}

	public int reverse(int x) {
		int y = 0;
		if (x > java.lang.Integer.MAX_VALUE / 2)
			return 0;
		if (x < java.lang.Integer.MIN_VALUE / 2) {
			return x;
		}
		String temp = String.valueOf(Math.abs(x));
		for (int i = temp.length(); i > 0; i--) {
			y += (x % 10) * Math.pow(10, i - 1);
			x = x / 10;
		}
		return y;

	}

	/**
	 * @author I321533
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		String temp = String.valueOf(x);
		for (int i = 0; i < temp.length() / 2; i++) {
			if (temp.charAt(i) != temp.charAt(temp.length() - 1 - i)) {
				return false;
			}
		}
		return true;
		// return new
		// StringBuffer(temp).reverse().toString().equalsIgnoreCase(temp);

	}

}
