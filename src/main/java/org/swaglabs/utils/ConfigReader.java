package org.swaglabs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


  private  static   Properties prop;


    public Properties init_prop(){

        prop = new Properties();

        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop.load(fis);
            fis.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return prop;
    }



    public String getProperty(String key){
        return prop.getProperty(key);
    }
}
