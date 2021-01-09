package com.dbyl.tests.algorithm.day6;

import com.dbyl.tests.algorithm.day2.Day2;
import org.testng.annotations.Test;

import junit.framework.Assert;

// TODO: Auto-generated Javadoc
/**
 * The Class Day6.
 *
 * @author young
 */
/**
 * @author young
 *
 */
public class Day6 {

	/** The array. */
	public int[][] array = new int[][] { { -10, 1, 12 }, { 23, 35, 46 }, { 77, 89, 93 }, { 123, 567, 999 } };

	/** The str. */
	StringBuffer str = new StringBuffer("We Are Happy.");
	
	Day2.ListNode listNode;

	/**
	 * Find.
	 *
	 * @param target
	 *            the target
	 * @param array
	 *            the array
	 * @return true, if successful
	 */
	public boolean Find(int target, int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (target == array[i][j]) {
					return true;

				}
			}
		}
		return false;
	}

	/**
	 * Verify find.
	 */
	@Test(enabled = false)
	public void verifyFind() {
		Assert.assertTrue(this.Find(-10, array));
		Assert.assertTrue(this.Find(999, array));
		Assert.assertTrue(this.Find(89, array));
		Assert.assertFalse(this.Find(315, array));
	}

	@Test
	public void verifyReplace() {
		Assert.assertTrue(this.replaceSpace(str).equals("We%20Are%20Happy."));
	}

	/**
	 * * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are
	 * Happy.则经过替换之后的字符串为We%20Are%20Happy。
	 *
	 * @param str
	 *            the str
	 * @return the string
	 */
	public String replaceSpace(StringBuffer str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				str.replace(i, i + 1, "%20");
			}
		}
		return str.toString();
	}
}
