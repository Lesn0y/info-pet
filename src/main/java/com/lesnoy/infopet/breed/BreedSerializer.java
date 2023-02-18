package com.lesnoy.infopet.breed;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.lesnoy.infopet.filter.Filter;
import com.lesnoy.infopet.entity.Parameters;

import java.io.IOException;

public class BreedSerializer extends StdSerializer<Breed> {

    public BreedSerializer() {
        this(null);
    }

    public BreedSerializer(Class<Breed> t) {
        super(t);
    }

    @Override
    public void serialize(Breed value,
                          JsonGenerator gen,
                          SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("id", value.getId());
        gen.writeStringField("breed", value.getName());
        gen.writeStringField("animal-type", value.getAnimal().getAnimalName());
        gen.writeStringField("thumbnail_url", value.getImgUrl());
        gen.writeArrayFieldStart("parameters");
            for(Parameters parameter : value.getParameters()){
                gen.writeStartObject();
                gen.writeStringField("parameter", parameter.getParameter());
                gen.writeStringField("value", parameter.getValue());
                gen.writeEndObject();
            }
        gen.writeEndArray();
        gen.writeArrayFieldStart("filters");
            for(Filter filter : value.getFilters()){
                gen.writeString(filter.getFilterName());
            }
        gen.writeEndArray();
        gen.writeStringField("subtitle", value.getSubtitle());
        gen.writeStringField("character", value.getCharacter());
        gen.writeStringField("training", value.getTraining());
        gen.writeStringField("diet", value.getDiet());
        gen.writeStringField("care", value.getCare());
        gen.writeStringField("breed-gallery", value.getPackageUrl());
        gen.writeEndObject();
    }
}
