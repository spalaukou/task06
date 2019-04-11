package by.epam.javawebtraining.spalaukou.task06.controller;

import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.AbstractToursBuilder;
import by.epam.javawebtraining.spalaukou.task06.model.logic.factory.TourBuilderFactory;
import by.epam.javawebtraining.spalaukou.task06.model.logic.validator.SAXValidator;
import by.epam.javawebtraining.spalaukou.task06.model.logic.validator.SAXXSDValidator;
import by.epam.javawebtraining.spalaukou.task06.util.Configurator;
import org.apache.log4j.Logger;

/**
 * @author Stanislau Palaukou on 09.04.2019
 * @project task06
 */

public class Main {
    private static final Logger LOGGER = Logger.getRootLogger();
    private static final String FILE_NAME = Configurator.getProperty("fileName");
    private static final String SCHEMA_NAME = Configurator.getProperty("schemaName");
    private static final String PARSER_TYPE = Configurator.getProperty("parserType");

    public static void main(String[] args) {
        LOGGER.trace("Start main.");

        // validating XML-document with XSD
        if(SAXValidator.isValid(FILE_NAME, SCHEMA_NAME) && SAXXSDValidator.isValid(FILE_NAME, SCHEMA_NAME)) {
            LOGGER.trace("Validating has been ended.");

            // parsing XML-document
            TourBuilderFactory tFactory = new TourBuilderFactory();
            AbstractToursBuilder builder = tFactory.createTourBuilder(PARSER_TYPE);
            LOGGER.trace("Parsing has been ended.");

            // building entities
            builder.buildSetTours(FILE_NAME);
            LOGGER.trace("Entities have been build.");

            // output entities
            LOGGER.trace("Output entities:");
            LOGGER.trace(builder.getTouristVouchers());
        }

        LOGGER.trace("End.");
    }
}
