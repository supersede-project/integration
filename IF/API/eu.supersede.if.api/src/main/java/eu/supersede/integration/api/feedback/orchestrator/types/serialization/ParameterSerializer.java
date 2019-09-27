package eu.supersede.integration.api.feedback.orchestrator.types.serialization;


import eu.supersede.integration.api.feedback.orchestrator.types.Parameter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.Assert;


public class ParameterSerializer extends JsonSerializer<Parameter> {

    @Override
    public void serialize(Parameter parameter, JsonGenerator jgen,
                          SerializerProvider provider) throws IOException,
            JsonProcessingException {
        if (parameter != null) {
            jgen.writeStartObject();
            jgen.writeNumberField("id", parameter.getId());
            jgen.writeStringField("key", parameter.getKey());
            if(parameter.getParameters() != null && parameter.getParameters().size() > 0) {
                jgen.writeArrayFieldStart("value");
                for(Parameter subParameter : parameter.getParameters()) {
                    jgen.writeObject(subParameter);
                }
                jgen.writeEndArray();
            } else {
                if(parameter.getValue() == null) {
                    jgen.writeObjectField("value", null);
                } else if(parameter.getValue().equals("true")) {
                    jgen.writeBooleanField("value", true);
                } else if(parameter.getValue().equals("false")) {
                    jgen.writeBooleanField("value", false);
                } else {
                    jgen.writeObjectField("value", parameter.getValue());
                }
            }
            if(parameter.getParameters() != null && parameter.getParameters().size() > 0) {
                jgen.writeArrayFieldStart("parameters");
                for(Parameter subParameter : parameter.getParameters()) {
                    jgen.writeObject(subParameter);
                }
                jgen.writeEndArray();
            } else {
                jgen.writeArrayFieldStart("parameters");
                jgen.writeEndArray();
            }
            jgen.writeStringField("language", parameter.getLanguage());
            if (parameter.getCreatedAt()!=null) {
            	String sDate = dateToString(parameter.getCreatedAt());
            	try {
            		Assert.isTrue(checkValidDate(sDate));
				} catch (ParseException e) {
					throw new IOException(e);
				}
            	jgen.writeStringField("createdAt", sDate);
            }
            if (parameter.getUpdatedAt()!=null) {
            	String sDate = dateToString(parameter.getUpdatedAt());
            	try {
					Assert.isTrue(checkValidDate(sDate));
				} catch (ParseException e) {
					throw new IOException(e);
				}
            	jgen.writeStringField("updatedAt", dateToString(parameter.getUpdatedAt()));
            }
            jgen.writeEndObject();
        } else {
            jgen.writeNull();
        }
    }

    private String dateToString(Date date) {
        if(date == null) {
            return null;
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return df.format(date);
    }
    
    public boolean checkValidDate (String stringDate) throws ParseException {
    	DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    	return df.parse(stringDate)!=null;
    }
}
