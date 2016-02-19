package com.dbyl.libarary.utils;

public class StringUtils {
	/**
	 * This method is for judge the string null or not null
	 * @author Young
	 * @param str
	 * @return
	 */
	public static boolean isNull(String str)
	{
		return (str==null? true:false);
	}

	/**
	 * This method is for judge the string is empty or not
	 * @author Young
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str)
	{
		return (str.equals("")?true:false);
	}
	
	/**
	 * This method is for judge null or empty
	 * @author Young
	 * @param str
	 * @return
	 */
	public static boolean isNullOrEmpty(String str)
	{
		return (isNull(str)||isEmpty(str));
	}
	
	
}
