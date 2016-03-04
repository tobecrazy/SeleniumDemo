package com.dbyl.libarary.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTools {
	/**
	 * This method is for judge the string null or not null
	 * 
	 * @author Young
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str) {
		return (str == null ? true : false);
	}

	/**
	 * This method is for judge the string is empty or not
	 * 
	 * @author Young
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str.equals("") ? true : false);
	}

	/**
	 * This method is for judge null or empty
	 * 
	 * @author Young
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str) {
		return (isNull(str) || isEmpty(str));
	}

	/**
	 * This method is for get the matcher string
	 * 
	 * @author Young
	 * @param source
	 * @param rex
	 * @return
	 */
	public static String getMatch(String source, String rex) {
		Pattern pattern = Pattern.compile(rex);
		Matcher matcher = pattern.matcher(source);
		if (matcher.find()) {
			return source.substring(matcher.start(), matcher.end());
		}
		return null;

	}

	/**
	 * get the match group
	 * 
	 * @author Young
	 * @param source
	 * @param rex
	 * @param groupIndex
	 * @return
	 */
	public static String getMatchGroup(String source, String rex, int groupIndex) {
		Pattern pattern = Pattern.compile(rex);
		Matcher matcher = pattern.matcher(source);
		if (matcher.find()) {
			return matcher.group(groupIndex);
		}
		return null;

	}

	/**
	 * This method is for replaceAll the string
	 * 
	 * @author Young
	 * @param source
	 * @param rex
	 * @param replaceBy
	 */
	public static void replaceAll(String source, String rex, String replaceBy) {
		Pattern pattern = Pattern.compile(rex);
		Matcher matcher = pattern.matcher(source);
		if (matcher.find()) {
			matcher.replaceAll(replaceBy);
		}
	}

	/**
	 * This method is for judge is match 
	 * @author Young
	 * @param source
	 * @param rex
	 * @return
	 */
	public static boolean isMatch(String source, String rex) {
		Pattern pattern = Pattern.compile(rex);
		Matcher matcher = pattern.matcher(source);
		return matcher.matches();
	}
}
