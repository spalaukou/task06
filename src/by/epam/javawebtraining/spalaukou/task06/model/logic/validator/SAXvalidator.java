package by.epam.javawebtraining.spalaukou.task06.model.logic.validator;

import by.epam.javawebtraining.spalaukou.task06.model.entity.voucher.TourErrorHandler;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

public class SAXvalidator {
    private static final Logger LOGGER = Logger.getRootLogger();

    public static boolean isValid(String fileName, String schemaName) {
        Schema schema;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {

            // setting checking with using XSD
            schema = factory.newSchema(new File(schemaName));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);

            // creating parser object
            SAXParser parser = spf.newSAXParser();

            // setting errors handler and starting
            parser.parse(fileName, new TourErrorHandler(LOGGER.toString()));
            LOGGER.trace("SAXvalidator: " + fileName + " is valid.");
            return true;
        } catch (ParserConfigurationException e) {
            LOGGER.error("SAXvalidator: " + fileName + " config error: " + e.getMessage());
        } catch (SAXException e) {
            LOGGER.error("SAXvalidator: " + fileName + " SAX error: " + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("I/O error: " + e.getMessage());
        }
        return false;
    }

}
