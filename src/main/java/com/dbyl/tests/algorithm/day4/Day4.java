package com.dbyl.tests.algorithm.day4;

import java.util.Random;

import org.testng.annotations.Test;

/**
 * 
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author I321533
 */
public class Day4 {

	@Test
	public void test() {
		// for (int i = 1; i <= 5000; i++) {
		// romanToInt(String.valueOf(5000));
		// }
		greatestCommonDivisor("mmmm", "abcdace");

	}

	public int romanToInt(String s) {

		int temp = Integer.parseInt(s);
		Random r = new Random();
		int result = r.nextInt(temp);
		while (result > 3999 || result < 1) {
			result = r.nextInt(temp);
		}
		System.out.println(result);
		return result;
	}

	/**
	 * @author young
	 * @param moves
	 * @return
	 */
	public boolean judgeCircle(String moves) {
		int l = 0;
		int r = 0;
		int u = 0;
		int d = 0;
		char[] temps = moves.toCharArray();
		for (char temp : temps) {
			if (temp == 'U' || temp == 'u') {
				u++;
			}
			if (temp == 'D' || temp == 'd') {
				d++;
			}
			if (temp == 'L' || temp == 'l') {
				l++;
			}
			if (temp == 'R' || temp == 'r') {
				d++;
			}
		}

		if ((l - r + u - d) == 0) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 求两个字符串最大公约数
	 * @author young
	 * @param first
	 * @param second
	 * @return
	 */
	public String greatestCommonDivisor(String first, String second) {
		String temp = null;
		if (first.length() < second.length()) {
			temp = first;
			first = second;
			second = temp;
		}

		for (int i = first.length(); i > 0; i--) {
			for (int j = second.length(); j > 0; j--) {
				if (first.substring(0, i).contains(second.substring(0, j))) {
					System.out.println("~~~~~" + second.substring(0, j));
					return second.substring(0, j);

				}
			}

		}
		return null;
	}
}
