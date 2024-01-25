package com.solvd.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.solvd.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateSerializer extends JsonSerializer<Date> {


    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final String CUSTOM_FORMAT_STRING = "yyyy-MM-dd";

    @Override
    public void serialize(Date value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        try {
            LOGGER.debug("Serializing Date: {}", value);
            gen.writeString(new SimpleDateFormat(CUSTOM_FORMAT_STRING).format(value));
        } catch (Exception e) {
            LOGGER.error("Error occurred during Date serialization.", e);
        }
    }

}
