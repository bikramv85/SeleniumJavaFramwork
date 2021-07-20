package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import Test.TESTNGDemo;

public class propertiesfiledemo {

	static Properties prop = new Properties();
	static String projectpath = System.getProperty("user.dir");

	public static void main(String[] args) throws Exception {
		getProperties();
		setproperties();
		getProperties();
	}

	public static void getProperties () {

		try {

			InputStream input = new FileInputStream(projectpath+"/src/test/java/config/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			TESTNGDemo.browsername = browser;

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}


	}



	public static void setproperties() throws Exception {

		try {
			OutputStream output = new FileOutputStream(projectpath+"/src/test/java/config/config.properties");
			prop.setProperty("result", "pass");
			prop.store(output, null);

		} catch (FileNotFoundException exp1) {

			System.out.println(exp1.getMessage());
			System.out.println(exp1.getCause());
			exp1.printStackTrace();
		}


	}


}
