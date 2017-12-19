/*******************************************************************************
 * Copyright (c) 2016 ATOS Spain S.A.
 * All rights reserved. Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Yosu Gorroñogoitia (ATOS) - main development
 *
 * Initially developed in the context of SUPERSEDE EU project www.supersede.eu
 *******************************************************************************/
package eu.supersede.integration.properties;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.supersede.integration.api.datastore.integration.types.SupersedePlatform;
import eu.supersede.integration.federation.SupersedeFederation;


public class IntegrationProperty {
	private static final Logger log = LoggerFactory.getLogger(IntegrationProperty.class);
	private static Properties prop = new Properties();
	private static String propFileName = "if.development.properties";
	private static SupersedeFederation federation;
	private static SupersedePlatform localPlatform;
	private static List<SupersedePlatform> federatedPlatforms;
	private static String mb_connection;
	
	static{
		//Read configuration from environment
		if (System.getProperty("supersede.if.properties")!=null){
			propFileName = System.getProperty("supersede.if.properties");
			System.out.println("Setting IF configuration to: " + propFileName);
		}else{
			System.out.println("Using default IF configuration: " + propFileName);
		}
		
		InputStream is = IntegrationProperty.class.getClassLoader().getResourceAsStream(propFileName);
		
		try {
			if (is != null){
				prop.load (is);
			}else{
				throw new RuntimeException("Property file '" + propFileName + "'not found in classpath");
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} 
		
		federation = new SupersedeFederation();
		localPlatform = federation.getLocalFederatedSupersedePlatform();
		federatedPlatforms = federation.getFederatedSupersedePlatforms();
		
		mb_connection = computeMBConnection();
	}
	
	public static String getProperty(String key){
		if (prop.containsKey(key)){
			return (String) prop.get (key);
		}else{
			throw new RuntimeException("Property '" + key + "' not found exception");
		}
	}
	
	private static String computeMBConnection (){
		String mb_connection = IntegrationProperty.getProperty("message.broker.connection");
		mb_connection = mb_connection.replaceFirst("<mb_user>", localPlatform.getMb_user());
		mb_connection = mb_connection.replaceFirst("<mb_password>", localPlatform.getMb_password().replace("$", "\\$"));
		mb_connection = mb_connection.replaceFirst("<mb_url>", localPlatform.getMb_url());
		return mb_connection;
	}
	
	public static String getMBConnection (){
		return mb_connection;
	}
	
	public static SupersedePlatform getLocalPlatform(){
		return localPlatform;
	}
	
	public static  List<SupersedePlatform> getFederatedPlatforms(){
		return federatedPlatforms;
	}

}
