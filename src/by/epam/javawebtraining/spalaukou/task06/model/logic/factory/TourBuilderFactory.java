package by.epam.javawebtraining.spalaukou.task06.model.logic.factory;

import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.AbstractToursBuilder;
import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.DOMBuilder.DOMBuilder;
import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.SAXBuilder.SAXBuilder;
import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.StAXBuilder.StAXBuilder;

/**
 * @author Stanislau Palaukou on 09.04.2019
 * @project task06
 */

public class TourBuilderFactory {

    private enum TypeParser {
        SAX, STAX, DOM;
    }

    public AbstractToursBuilder createTourBuilder(String typeParser) {
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM:
                return new DOMBuilder();
            case STAX:
                return new StAXBuilder();
            case SAX:
                return new SAXBuilder();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }
    }
}
