package Utilities;

import org.openqa.selenium.WebDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LocatorReader {
    private Properties props;

    public LocatorReader(String path) throws IOException {

        props = new Properties();
        FileReader Fr = new FileReader(path);
        props.load(Fr);

    }

    public String get(String key){
        return props.getProperty(key);
    }

}
