package by.epam.javawebtraining.spalaukou.task06.model.logic.builder.SAXbuilder;

import by.epam.javawebtraining.spalaukou.task06.model.entity.voucher.TouristVoucher;
import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.AbstractToursBuilder;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

public class SAXbuilder extends AbstractToursBuilder {
    private static final Logger LOGGER = Logger.getRootLogger();
    private static SAXbuilder instance;
    private Set<TouristVoucher> touristVouchers;
    private TouristVoucherHandler sh;
    private XMLReader reader;

    public static SAXbuilder getInstance() {
        if (instance == null) {
            instance = new SAXbuilder();
            return instance;
        }
        else {
            return instance;
        }
    }

    private SAXbuilder() {
        // creating SAX-analyzer
        sh = new TouristVoucherHandler();
        try {
            // creating handler object
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(sh);
        } catch (SAXException e) {
            LOGGER.error("SAX parser Error: " + e);
        }
    }

    public Set<TouristVoucher> getTouristVouchers() {
        return touristVouchers;
    }

    @Override
    public void buildSetTours(String fileName) {
        try {
            // parsing XML-document
            reader.parse(fileName);
        } catch (SAXException e) {
            LOGGER.error("SAX parser Error: " + e);
        } catch (IOException e) {
            LOGGER.error("I/O stream Error: " + e);
        }
        touristVouchers = sh.getTouristVouchers();
    }
}
