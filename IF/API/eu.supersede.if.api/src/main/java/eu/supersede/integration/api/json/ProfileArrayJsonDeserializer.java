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

import eu.supersede.integration.api.datastore.fe.types.Profile;

public class ProfileArrayJsonDeserializer extends JsonDeserializer<List<Profile>> {

    private static final String PROFILE = "profile";
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final CollectionType collectionType =
            TypeFactory
            .defaultInstance()
            .constructCollectionType(List.class, Profile.class);

    @Override
    public List<Profile> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        ObjectNode objectNode = mapper.readTree(jsonParser);
        JsonNode nodeProfiles = objectNode.get(PROFILE);

        if (null == nodeProfiles                     // if no profile node could be found
                || !nodeProfiles.isArray()           // or profile node is not an array
                || !nodeProfiles.elements().hasNext())   // or profile node doesn't contain any profiles
            return null;

        return mapper.reader(collectionType).readValue(nodeProfiles);
    }
}