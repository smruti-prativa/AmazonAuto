package com.amazonAuto.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConfigPropLoader {
	public static String browser;
	public static String url;
	public static String username;
	public static String password;
	
	private static Properties properties;
	private static Logger log=Logger.getLogger(ConfigPropLoader.class);
	
	public static void mapPropertiesToConstants(String filePath) throws IOException {
		log.info("The config file path is: "+filePath);
		properties = new Properties();
		InputStream ioStream=new FileInputStream(filePath);
		properties.load(ioStream);
        try {
            List<Field> fields = Arrays.asList(ConfigPropLoader.class.getFields());
            for (Field field : fields) {
                if (null == properties.getProperty(field.getName())) {
                    if (field.get(field.getName()) == null)
                    	log.error("Field is missing in property File : " + field.getName());
                    continue;
                }
                field.set(ConfigPropLoader.class, properties.getProperty(field.getName()));
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
