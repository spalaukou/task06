package by.epam.javawebtraining.spalaukou.task06.controller;

import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.AbstractToursBuilder;
import by.epam.javawebtraining.spalaukou.task06.model.logic.factory.TourBuilderFactory;
import by.epam.javawebtraining.spalaukou.task06.model.logic.validator.SAXValidator;
import by.epam.javawebtraining.spalaukou.task06.model.logic.validator.SAXXSDValidator;

/**
 * @author Stanislau Palaukou on 09.04.2019
 * @project task06
 */

public class Main {
    public static final String fileName = "data/tours.xml";
    public static final String schemaName = "data/tours.xsd";
    public static final String typeParser = "stax"; // dom, sax, stax

    public static void main(String[] args) {
        // validating XML-document with XSD
        SAXValidator.validate(fileName, schemaName);
        SAXXSDValidator.validate(fileName, schemaName);

        // parsing XML-document
        TourBuilderFactory tFactory = new TourBuilderFactory();
        AbstractToursBuilder builder = tFactory.createTourBuilder(typeParser);
        // building entities
        builder.buildSetTours(fileName);
        // output entities
        System.out.println(builder.getTouristVouchers());
    }
}
