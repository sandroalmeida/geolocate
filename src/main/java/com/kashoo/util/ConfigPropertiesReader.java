package com.kashoo.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigPropertiesReader {

    public static final String FILE_NAME = "config.properties";

    public static String getProperty(String key){

        String property = "";
        String basePath = System.getProperty("user.dir");
        String systemPath = "/src/main/resources/";
        try (InputStream input = new FileInputStream(basePath + systemPath + FILE_NAME)) {
            Properties prop = new Properties();
            prop.load(input);
            property = prop.getProperty(key);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return property;
    }

}
