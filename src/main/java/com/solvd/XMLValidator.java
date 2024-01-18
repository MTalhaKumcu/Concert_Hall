package com.solvd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.validation.Schema;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static boolean validateXmlAgainsrXsd(File xmlFile ,File xsdFile) throws IOException {
        try{
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xsdFile);

            Validator validator = schema.newValidator();

            validator.validate(new StreamSource(xmlFile));

            return  true;
        }catch (SAXException e){
            e.printStackTrace();
            return false;
        }
    }
    public static void main(String args[]) throws IOException {
        File xmlFile = new File("src/main/resources/Concert_Hall.xml");
        File xsdFile = new File("src/main/resources/Concert_hall.xsd");

    if (validateXmlAgainsrXsd(xmlFile,xsdFile)){
        LOGGER.info("XML File is avaliable for XSD File !");
    }else {
        LOGGER.info("XML File is not avaliable for XSD File !");

    }

    }
}
