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
