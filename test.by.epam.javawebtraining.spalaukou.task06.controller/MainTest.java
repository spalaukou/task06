import by.epam.javawebtraining.spalaukou.task06.model.entity.voucher.TouristVoucher;
import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.AbstractToursBuilder;
import by.epam.javawebtraining.spalaukou.task06.model.logic.factory.TourBuilderFactory;
import by.epam.javawebtraining.spalaukou.task06.model.logic.validator.SAXValidator;
import by.epam.javawebtraining.spalaukou.task06.model.logic.validator.SAXXSDValidator;
import by.epam.javawebtraining.spalaukou.task06.util.Configurator;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author Stanislau Palaukou on 14.04.2019
 * @project task06
 */

public class MainTest {
    AbstractToursBuilder builder;

    @BeforeMethod
    public void setUp() {
        String FILE_NAME = Configurator.getProperty("fileName");
        String SCHEMA_NAME = Configurator.getProperty("schemaName");
        String PARSER_TYPE = Configurator.getProperty("parserType");

        if(SAXValidator.isValid(FILE_NAME, SCHEMA_NAME) && SAXXSDValidator.isValid(FILE_NAME, SCHEMA_NAME)) {
            TourBuilderFactory tFactory = new TourBuilderFactory();
            builder = tFactory.createTourBuilder(PARSER_TYPE);
            builder.buildSetTours(FILE_NAME);
        }
    }

    @Test
    public void testMain() {
        int expectedAllNights = 19;
        int actualAllNights = 0;

        for(TouristVoucher tv : builder.getTouristVouchers()) {
            actualAllNights += tv.getNumberNights();
        }

        assertEquals(expectedAllNights, actualAllNights);
    }
}