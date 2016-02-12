package eu.supersede.integration.properties;

import java.io.InputStream;
import java.util.Properties;

public class IntegrationProperty {
	public static Properties prop = new Properties();
	public static String propFileName = "if.properties";
	static{
		InputStream is = IntegrationProperty.class.getClassLoader().getResourceAsStream(propFileName);
		
		try {
			if (is != null){
				prop.load (is);
			}else{
				throw new RuntimeException("Property file '" + propFileName + "'not found in classpath");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static String getProperty(String key){
		if (prop.containsKey(key)){
			return (String) prop.get (key);
		}else{
			throw new RuntimeException("Property '" + key + "' not found exception");
		}
	}

}
