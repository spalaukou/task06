package by.epam.javawebtraining.spalaukou.task06.model.logic.factory;

import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.AbstractToursBuilder;
import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.DOMbuilder.DOMbuilder;
import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.SAXbuilder.SAXbuilder;
import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.StAXbuilder.StAXbuilder;

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
                return DOMbuilder.getInstance();
            case STAX:
                return StAXbuilder.getInstance();
            case SAX:
                return SAXbuilder.getInstance();
            default:
                throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
        }
    }
}
