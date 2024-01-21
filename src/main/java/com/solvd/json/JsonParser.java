package com.solvd.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.Main;
import com.solvd.model.Artist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class JsonParser {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        File jsonFile = new File("com/solvd/json/JsonParser.java");

        ObjectMapper objectMapper = new ObjectMapper();
        Artist artist;
        try {
            artist = objectMapper.readValue(jsonFile, Artist.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LOGGER.info("New json artist added: ", artist);
    }
}
