package by.epam.javawebtraining.spalaukou.task06.model.logic.validator;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

public class SAXXSDvalidator {
    private static final Logger LOGGER = Logger.getRootLogger();

    public static boolean isValid(String fileName, String schemaName) {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(schemaName);
        try {

            // creating schema
            Schema schema = factory.newSchema(schemaLocation);

            // creating validator on schema
            Validator validator = schema.newValidator();

            // checking document
            Source source = new StreamSource(fileName);
            validator.validate(source);
            LOGGER.trace("SAXXSDvalidator: " + fileName + " is valid.");
            return true;
        } catch (SAXException e) {
            LOGGER.error("SAXXSDvalidator: validation " + fileName + " is not valid because "
                    + e.getMessage());
        } catch (IOException e) {
            LOGGER.error("SAXXSDvalidator: " + fileName + " is not valid because "
                    + e.getMessage());
        }
        return false;
    }
}
