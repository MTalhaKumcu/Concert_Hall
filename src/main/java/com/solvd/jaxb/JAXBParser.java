package com.solvd.jaxb;

import com.solvd.Main;
import com.solvd.model.Artist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class JAXBParser {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Artist artist;
        try {
            File xmlFile = new File("src/main/resources/Concert_Hall.xml");

            JAXBContext jaxbContext = JAXBContext.newInstance(Artist.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            artist = (Artist)  jaxbUnmarshaller.unmarshal(xmlFile);

        }catch (JAXBException e){
            throw new RuntimeException(e);
        }
        logger.info(artist);
    }
}
