package com.solvd.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.Main;
import com.solvd.model.Artist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class DateSerializer {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        File file = new File("src/java/main/com/solvd/json/JsonParser.java");

        ObjectMapper objectMapper = new ObjectMapper();
        Artist artist;
        try {
            artist = objectMapper.readValue(file,Artist.class);
        }catch (IOException e)
        {
            throw new RuntimeException();
        }
        LOGGER.info("New json Serializer queue artist: ", artist);

    }

}
