package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromConfigPropertiesFile {
	
public static void readData() throws IOException {
	
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream("C:\\Users\\301584\\eclipse-workspace\\CCBDatabse\\Config.properties");
	prop.load(fis);
	
}

}
