package eu.supersede.integration.api.json;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import eu.supersede.integration.api.datastore.fe.types.Profile;

public class NillableObjectJsonDeserializer extends JsonDeserializer<String> {

    private static final String NIL = "@nil";
    private static final ObjectMapper mapper = new ObjectMapper();

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        Object objectNode = mapper.readTree(jsonParser);
        String nodeText = null;
        if  (objectNode instanceof ObjectNode){
        	nodeText = ((ObjectNode)objectNode).get(NIL).textValue();
        }else if (objectNode instanceof TextNode){
        	nodeText = ((TextNode)objectNode).textValue();
        }

        if (null == nodeText || nodeText.equals("true")) // locale node is nil
            return "";

        return nodeText;
    }
}