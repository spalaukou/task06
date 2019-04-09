package by.epam.javawebtraining.spalaukou.task06.model.logic.parser;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

public class TouristVoucherHandler extends DefaultHandler {
    @Override
    public void startDocument() {
        System.out.println("Parsing started.");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        String s = localName;
        // getting and output information about element attributes
        for (int i = 0; i < attrs.getLength(); i++) {
            s += " " + attrs.getLocalName(i) + "=" + attrs.getValue(i);
        }
        System.out.print(s.trim());
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        System.out.print(new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        System.out.print(localName);
    }

    @Override
    public void endDocument() {
        System.out.println("\nParsing ended.");
    }
}

