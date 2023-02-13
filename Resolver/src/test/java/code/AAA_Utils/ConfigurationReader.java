package code.AAA_Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    /**
     *
     This code sets up a way to read and access values from a configuration file.
     The file contains key-value pairs that specify various settings and parameters used in the application.
     The code provides a convenient way to load the properties from the file and store them in an instance of the java.util.Properties class. **/

    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
    private static Properties properties = new Properties();

    static {
        String PropertiesFilePath = "Configuration.properties";
        try {
            FileInputStream fileInputStream = new FileInputStream(PropertiesFilePath);
            properties.load(fileInputStream);
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Properties File Not Found!");
        }
    }

    /**
     *
     This code provides a way to access the value of a specific setting from the configuration file by providing the corresponding keyword.
     It retrieves the value for the specified keyword from the properties file and returns it to the caller. **/

    // ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓ ↓
    public static String getProperties(String keyword) {
        return properties.getProperty(keyword);
    }
}
