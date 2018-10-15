package eu.supersede.integration.api.security;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IFAccount {
	private static final Logger log = LoggerFactory.getLogger(IFAccount.class);

	private static String user = null;
	private static String password = null;
	
	static{
		readAccountProperties();
	}
	
	public static String getUser (){
		return user;
	}
	
	public static String getPassword(){
		return password;
	}
	
	private static void readAccountProperties() {
		Properties account = new Properties();
		InputStream input = null;

		try {

			String filename = "ifaccount.properties";
			input = IFAccount.class.getClassLoader().getResourceAsStream(filename);
			if (input == null) {
				log.error(filename + " cannot be found in test classpath");
				return;
			}

			// load a properties file from class path, inside static method
			account.load(input);
			
			user = account.getProperty("user");
			password = account.getProperty("password");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
