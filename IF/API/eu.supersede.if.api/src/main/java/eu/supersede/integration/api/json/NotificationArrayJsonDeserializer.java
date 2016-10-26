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
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import eu.supersede.integration.api.datastore.fe.types.Notification;

public class NotificationArrayJsonDeserializer extends JsonDeserializer<List<Notification>> {

    private static final String NOTIFICATION = "notification";
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final CollectionType collectionType =
            TypeFactory
            .defaultInstance()
            .constructCollectionType(List.class, Notification.class);

    @Override
    public List<Notification> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {

        ObjectNode objectNode = mapper.readTree(jsonParser);
        JsonNode nodeNotifications = objectNode.get(NOTIFICATION);

        if (null == nodeNotifications                     // if no notification node could be found
                || !nodeNotifications.isArray()           // or notification node is not an array
                || !nodeNotifications.elements().hasNext())   // or notification node doesn't contain any authors
            return null;

        return mapper.reader(collectionType).readValue(nodeNotifications);
    }
}