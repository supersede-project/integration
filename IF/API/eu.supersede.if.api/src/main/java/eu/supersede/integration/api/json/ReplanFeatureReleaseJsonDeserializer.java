package eu.supersede.integration.api.json;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import eu.supersede.integration.api.datastore.fe.types.Notification;

public class ReplanFeatureReleaseJsonDeserializer extends JsonDeserializer<Integer> {

    private static final String RELEASE_ID = "release_id";
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final CollectionType collectionType =
            TypeFactory
            .defaultInstance()
            .constructCollectionType(List.class, Notification.class);

    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

    	JsonNode node = mapper.readTree(jsonParser);
    	
    	if (! (node instanceof ObjectNode))
    		return null;
    	
        ObjectNode objectNode = (ObjectNode) node;
        IntNode releaseId = (IntNode) objectNode.get(RELEASE_ID);

        return releaseId.asInt();
    }
}