package commonImplementations.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReaderUtil {

    public static Properties readConfigProperties(String filename) throws IOException {
        filename = filename.trim();

        InputStream fileReader = new FileInputStream(filename); //text in the file is assigned

        Properties properties = new Properties();//Able to read the text in key and value pair

        properties.load(fileReader); //assigns the text in key and value pair

        return properties;

    }
}
