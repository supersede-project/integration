package eu.supersede.integration.datasource.poc.authentication.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class CustomJsonDateDeserializer extends JsonDeserializer<Date>
{
    @Override
    public Date deserialize(JsonParser jsonparser,
            DeserializationContext deserializationcontext) throws IOException, JsonProcessingException {

        SimpleDateFormat sdfIn = new SimpleDateFormat("yyyy-MM-dd+HH:mm");
        String date = jsonparser.getText();
        
        try {
        	return sdfIn.parse(date);
        } catch (ParseException | java.text.ParseException e) {
            throw new RuntimeException(e);
        }

    }
    
    public static void main (String[] args) throws java.text.ParseException{
    	String inputDate = "2015-03-22+01:00";
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd+HH:mm");
    	Date parsedDate = sdf.parse(inputDate);
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    	System.out.println(format.format(parsedDate));
    }
}