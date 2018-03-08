package eu.supersede.integration.api.feedback.orchestrator.types.serialization;

import eu.supersede.integration.api.feedback.orchestrator.types.Parameter;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;


public class ParameterSerializerModifier extends BeanSerializerModifier {
    @Override
    public JsonSerializer<?> modifySerializer(SerializationConfig config, BeanDescription beanDesc, JsonSerializer<?> serializer) {
        if (beanDesc.getBeanClass() == Parameter.class) {
            return new ParameterDefaultSerializer((JsonSerializer<Object>) serializer);
        }
        return serializer;
    }
}