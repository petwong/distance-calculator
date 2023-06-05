package com.petwong.distancecalculator;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.elasticsearch.common.unit.DistanceUnit;

import java.io.IOException;

public class DistanceDeserializer extends StdDeserializer<DistanceUnit.Distance> {

    public DistanceDeserializer() {
        this(null);
    }

    protected DistanceDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public DistanceUnit.Distance deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JacksonException {
        JsonNode node = jp.getCodec().readTree(jp);
        double value = node.get("value").doubleValue();
        DistanceUnit unit = DistanceUnit.valueOf(node.get("unit").asText());
        return new DistanceUnit.Distance(value, unit);
    }
}
