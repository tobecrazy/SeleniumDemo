package com.dbyl.libarary.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {

	private static Log log = new Log(ConfigUtils.class);

	public static Properties getProperties(String config) throws IOException {
		Properties properties = new Properties();
		log.info("Get the config file: "+config);
		FileInputStream inStream = new FileInputStream(new File(config));
		properties.load(inStream);
		return properties;
	}
}
