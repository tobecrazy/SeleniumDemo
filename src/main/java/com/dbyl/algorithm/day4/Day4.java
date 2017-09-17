package main.java.com.dbyl.algorithm.day4;

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
		for (int i = 1; i <= 5000; i++) {
			romanToInt(String.valueOf(5000));
		}

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
}
