package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class RunTest {
	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		try {
			//prop.store(new FileOutputStream("resources/driver.properties"), "prop my mini");
			prop.storeToXML(new FileOutputStream("resources/query.xml"), "prop my mini");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
