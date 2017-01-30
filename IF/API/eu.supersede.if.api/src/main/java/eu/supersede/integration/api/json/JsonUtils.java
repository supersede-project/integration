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
package eu.supersede.integration.api.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	public static JsonNode evaluatePathInJson (String json, String path){
		JsonNode result = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(json);
			result = root.at(path);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return result;
	}
	
	public static <T> String serializeObjectAsJsonString (T obj) throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
	
	public static <T> T deserializeJsonStringAsObject (String json, Class<T> clazz) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		return mapper.readValue(json, clazz);
	}
}
