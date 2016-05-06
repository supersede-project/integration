package eu.supersede.integration.api.json;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import eu.supersede.integration.api.datastore.fe.types.Label;

public class LabelArrayJsonDeserializer extends JsonDeserializer<List<Label>> {

    private static final String LABEL = "label";
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final CollectionType collectionType =
            TypeFactory
            .defaultInstance()
            .constructCollectionType(List.class, Label.class);

    @Override
    public List<Label> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        ObjectNode objectNode = mapper.readTree(jsonParser);
        JsonNode nodeLabels = objectNode.get(LABEL);

        if (null == nodeLabels                     // if no label node could be found
                || !nodeLabels.isArray()           // or label node is not an array
                || !nodeLabels.elements().hasNext())   // or label node doesn't contain any profiles
            return null;

        return mapper.reader(collectionType).readValue(nodeLabels);
    }
}