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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

public class CustomJsonDateDeserializer extends JsonDeserializer<Date>
{
//    @Override
//    public Date deserialize(JsonParser jsonparser,
//            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {
//    	Date result = null;
//        SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd+HH:mm");
//        String date = jsonparser.getText();
//        try {
//        	result = sdfIn.parse(date);
//        } catch (ParseException e) {
//        	//Parsing notification dates
//        	date = date.substring(0, date.indexOf('.'));
//        	date = date.replace('T', ' ');
//            sdfIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			try {
//				result = sdfIn.parse(date);
//			} catch (ParseException e1) {
//				e1.printStackTrace();
//			}
//        }
//        
//        return result;
//    }
    
	private String[] dateFormats = 
			new String[]{"yyyy-MM-dd+HH:mm", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"};
	
    @Override
    public Date deserialize(JsonParser jsonparser,
            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {
        String date = jsonparser.getText();
        return formatDate (date, dateFormats, 0);
    }
    
    private Date formatDate (String date, String[] dateFormats, int index){
    	Date result = null;
    	if (index >= dateFormats.length){
    		return result;
    	}
    	
        SimpleDateFormat sdfIn = new SimpleDateFormat(dateFormats[index]);
        try {
        	return sdfIn.parse(date);
        } catch (ParseException e) {
        	return formatDate (date, dateFormats, ++index);
        }
    }
    
    public static void main (String[] args) throws java.text.ParseException{
    	String inputDate = "2015-03-22+01:00";
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd+HH:mm");
    	Date parsedDate = sdf.parse(inputDate);
    	
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    	System.out.println(format.format(parsedDate));
    	
    	//CreateAt date deserializer for Feedback Gathering orchestrator
    	inputDate = "2016-08-13 05:07:31.0";
    	sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
    	parsedDate = sdf.parse(inputDate);
    	System.out.println(format.format(parsedDate));
    }
}