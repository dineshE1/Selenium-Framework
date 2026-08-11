package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	public static Properties properties;
	
	static {
		try {
			FileInputStream File = new FileInputStream("src/main/resources/config.properties");
			properties = new Properties();
			properties.load(File);
			System.out.println("Config loaded ✅");
		}
		catch(IOException e){
			System.out.println("Config file not found! ❌");
            e.printStackTrace();
		}
		
	}
	
	public static String get(String key) {
		return properties.getProperty(key);
	}
}
