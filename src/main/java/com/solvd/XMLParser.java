package com.solvd;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class XMLParser {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void parseXmlFile(File xmlFile) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);


            Element rootElement = document.getDocumentElement();
            LOGGER.info("Root element => ", rootElement.getNodeName());

            // Iterate through child elements
            NodeList childNodes = rootElement.getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                if (childNodes.item(i) instanceof Element) {
                    Element element = (Element) childNodes.item(i);
                    LOGGER.info("Element Name => ", element.getNodeName());

                }

            }


        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException | SAXException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        File xmlFile = new File("src/main/resources/Concert_Hall.xml");
        parseXmlFile(xmlFile);
    }
}


