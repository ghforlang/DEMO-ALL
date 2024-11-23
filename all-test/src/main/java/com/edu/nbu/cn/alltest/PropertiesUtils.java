package com.edu.nbu.cn.alltest;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author laoshi . hua
 * @version 1.0 2022/8/23-2:50 PM
 * @since 1.0
 */
public class PropertiesUtils {

    public static Map<String,String> loadFromProperties(String filePath){
        Map<String,String> resultMap = new HashMap<>();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try {
            Enumeration<URL> urls = classLoader.getResources(filePath);
            while(urls.hasMoreElements()){
                URL url = urls.nextElement();
                URLConnection urlConnection = url.openConnection();
                properties.load(urlConnection.getInputStream());
            }
            for(String propertyName : properties.stringPropertyNames()){
                String propertyValue = (String)properties.get(propertyName);
                resultMap.put(propertyName,propertyValue);
            }
            return resultMap;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
