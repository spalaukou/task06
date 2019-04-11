package by.epam.javawebtraining.spalaukou.task06.util;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;


public class Configurator {
	private static final String CONFIG_FILE_PATH = "src/config.xml";

	private static Logger LOGGER = Logger.getRootLogger();
	private static Properties property;

	static {
		property = new Properties();

		try (FileInputStream fileInputStream = new FileInputStream(CONFIG_FILE_PATH)) {

            property.loadFromXML(fileInputStream);

        } catch (IOException e) {
            LOGGER.warn(e);
            e.printStackTrace();
        }
	}

	private Configurator() {}

	public static String getProperty(String key) {
		String value = "";
		if(key != null) {
			value = property.getProperty(key);
		}
		return value;
	}

}
