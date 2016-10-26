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