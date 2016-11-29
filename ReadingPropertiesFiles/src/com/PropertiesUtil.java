package com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private static final String USER_HOME = System.getProperty("user.home");
	private static final String FILE_NAME = "user.properties";
	private static Properties PROPS = null;

	private PropertiesUtil() {
		System.out.println("\n USER_HOME " + USER_HOME);
	}

	public static String getConfig(String key) {
		return getProperties().getProperty(key);

	}

	public static Properties getProperties() {
		System.out.println("\n USER_HOME " + USER_HOME);
		System.out.println("\n FILE_NAME " + FILE_NAME);
		synchronized (PropertiesUtil.class) {
			if (PROPS == null) {
				File propsFile = new File(USER_HOME, FILE_NAME);
				PROPS = new Properties();
				try {
					FileInputStream in = new FileInputStream(propsFile);
					PROPS.load(in);
					in.close();
				} catch (IOException e) {
					throw new RuntimeException(e);

				}
			}

		}
		return PROPS;
	}

}
