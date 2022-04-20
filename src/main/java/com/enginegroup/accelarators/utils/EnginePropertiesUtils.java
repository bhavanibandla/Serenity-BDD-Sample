package com.enginegroup.accelarators.utils;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class EnginePropertiesUtils {

    private String enginePropertyFile = "testdata.properties";
    Properties properties;

    public EnginePropertiesUtils(){
        fileProcessor();
    }

    public EnginePropertiesUtils(String testName){
        if(testName.equalsIgnoreCase("api"))
            enginePropertyFile = "reqresp.properties";
        else
            enginePropertyFile = "testdata.properties";
        fileProcessor();
    }

    public void fileProcessor(){
        properties = new Properties();
        try {
            InputStream inputStream = EnginePropertiesUtils.class.getClassLoader().getResourceAsStream(enginePropertyFile);
            properties.load(inputStream);
        } catch(FileNotFoundException e){
            System.out.println("Property File could not be found: "+ enginePropertyFile);
        } catch(Exception e){
            System.out.println("Issues reading properties of :"+ enginePropertyFile);
        }
    }

    public String getProperty(String key){
        String value = "";
        try{
            value = properties.getProperty(key);
        }
        catch (Exception e){
            System.out.println("Unable to find the key : "+key);
        }
        finally {
            return value;
        }
    }
}
