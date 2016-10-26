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
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomJsonTimestampDeserializer extends JsonDeserializer<Timestamp>{
	private String[] timeStampFormats = 
			new String[]{"yyyy-MM-dd HH:mm:ss.SSS"};
	
    @Override
    public Timestamp deserialize(JsonParser jsonparser,
            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {
        String timeStamp = jsonparser.getText();
        return formatDate (timeStamp, timeStampFormats, 0);
    }
    
    private Timestamp formatDate (String timeStamp, String[] timeStampFormats, int index){
    	Timestamp result = null;
    	if (index >= timeStampFormats.length){
    		return result;
    	}
    	
        SimpleDateFormat sdfIn = new SimpleDateFormat(timeStampFormats[index]);
        try {
        	 Date date = sdfIn.parse(timeStamp);
        	 return new Timestamp(date.getTime());
        } catch (ParseException e) {
        	return formatDate (timeStamp, timeStampFormats, ++index);
        }
    }
}
