package by.epam.javawebtraining.spalaukou.task06.controller;

import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.AbstractToursBuilder;
import by.epam.javawebtraining.spalaukou.task06.model.logic.factory.TourBuilderFactory;
import by.epam.javawebtraining.spalaukou.task06.model.logic.validator.SAXValidator;
import by.epam.javawebtraining.spalaukou.task06.model.logic.validator.SAXXSDValidator;
import org.apache.log4j.Logger;

/**
 * @author Stanislau Palaukou on 09.04.2019
 * @project task06
 */

public class Main {
    private static final Logger LOGGER = Logger.getRootLogger();

    private static final String fileName = "data/tours.xml";
    private static final String schemaName = "data/tours.xsd";
    private static final String typeParser = "dom"; // dom, sax, stax

    public static void main(String[] args) {
        LOGGER.trace("Start main.");

        // validating XML-document with XSD
        if(SAXValidator.isValid(fileName, schemaName) && SAXXSDValidator.isValid(fileName, schemaName)) {
            LOGGER.trace("Validating has been ended.");

            // parsing XML-document
            TourBuilderFactory tFactory = new TourBuilderFactory();
            AbstractToursBuilder builder = tFactory.createTourBuilder(typeParser);
            LOGGER.trace("Parsing has been ended.");

            // building entities
            builder.buildSetTours(fileName);
            LOGGER.trace("Entities have been build.");

            // output entities
            LOGGER.trace("Output entities:");
            LOGGER.trace(builder.getTouristVouchers());
        }

        LOGGER.trace("End.");
    }
}
