package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Read_Properties {

    public static Properties prop;

    public static Properties readProperty() throws IOException {

        String filepath = System.getProperty("user.dir")
                + "/src/main/java/Configuration/config.properties";

        FileInputStream fis = new FileInputStream(filepath);

        prop = new Properties();
        prop.load(fis);

        return prop;
    }
}