package eu.supersede.integration.api.feedback.orchestrator.types.serialization;


import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import eu.supersede.integration.api.feedback.orchestrator.types.Parameter;

import static com.google.common.base.Preconditions.checkNotNull;

public class ParameterDefaultSerializer extends JsonSerializer<Parameter> {

    private final JsonSerializer<Object> defaultSerializer;

    public ParameterDefaultSerializer(JsonSerializer<Object> defaultSerializer) {
        this.defaultSerializer = checkNotNull(defaultSerializer);
    }

    @Override
    public void serialize(Parameter parameter, JsonGenerator jgen,
                          SerializerProvider provider) throws IOException,
            JsonProcessingException {
        defaultSerializer.serialize(parameter, jgen, provider);
    }
}
