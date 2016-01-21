package eu.supersede.integration.poc.dynadapt;

import java.io.InputStream;
import java.util.Properties;

public class DynAdaptProperty {
	public static Properties prop = new Properties();
	public static String propFileName = "dynadapt.properties";
	static{
		InputStream is = DynAdaptProperty.class.getClassLoader().getResourceAsStream(propFileName);
		
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
