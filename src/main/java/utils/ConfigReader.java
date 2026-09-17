package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	public static Properties initializeProperties() {
		Properties p=new Properties();
		File f =new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		try {
		FileInputStream file=new FileInputStream(f);
		p.load(file);
	}catch(Throwable e) {
		e.printStackTrace();
	}
		return p;

}

	 
}
