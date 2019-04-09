package by.epam.javawebtraining.spalaukou.task06.model.logic.parser;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

public class SAXSimpleMain {
        public static void main(String[ ] args) {
            try {
                // creating SAX-analyzer
                XMLReader reader = XMLReaderFactory.createXMLReader();
                TouristVoucherHandler handler = new TouristVoucherHandler();
                reader.setContentHandler(handler);
                reader.parse("data/tours.xml");
            } catch (SAXException e) {
                System.err.print("SAX parser Error: " + e);
            } catch (IOException e) {
                System.err.print("I/O stream Error: " + e);
            }
        }
    }
