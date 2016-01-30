package com.dbyl.libarary.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This method is for get the config file
 * @author Young
 *
 */
public class ConfigUtils {

	private static Log log = new Log(ConfigUtils.class);

	public static Properties getProperties(String config) throws IOException {
		Properties properties = new Properties();
		log.info("Get the config file: " + config);
		FileInputStream inStream = new FileInputStream(new File(config));
		try {
			properties.load(inStream);
		} catch (Exception e) {
			log.error("can't find the config file ");
			log.error(e.getMessage());
		}

		return properties;
	}
}
