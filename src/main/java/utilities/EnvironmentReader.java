package utilities;

import java.io.IOException;
import java.util.Properties;

public class EnvironmentReader {

    public static Properties properties = new Properties();

    public static void load(){
        try {
            properties.load(EnvironmentReader.class.getClassLoader()
                    .getResourceAsStream("properties/environment.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not read the properties file", e);
        }
    }

    public static String getUrl(){
        return properties.getProperty("url");
    }

}
