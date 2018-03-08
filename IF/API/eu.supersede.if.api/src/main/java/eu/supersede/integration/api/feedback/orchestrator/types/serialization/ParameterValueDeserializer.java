package eu.supersede.integration.api.feedback.orchestrator.types.serialization;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class ParameterValueDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if(p.getText() == null || p.getText().trim().substring(0,1).equals("[")) {
            return null;
        } else {
            return p.getValueAsString();
        }
    }
}
