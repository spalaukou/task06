package by.epam.javawebtraining.spalaukou.task06.model.logic.parser;

import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

public class TouristVoucherHandler extends DefaultHandler {
    private static final Logger LOGGER = Logger.getRootLogger();

    @Override
    public void startDocument() {
        LOGGER.trace("Parsing started.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        String s = localName;
        // getting and output information about element attributes
        for (int i = 0; i < attrs.getLength(); i++) {
            s += " " + attrs.getLocalName(i) + "=" + attrs.getValue(i);
        }
        LOGGER.trace(s.trim());
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        LOGGER.trace(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        LOGGER.trace(localName);
    }

    @Override
    public void endDocument() {
        LOGGER.trace("\nParsing ended.");
    }
}

