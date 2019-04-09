package by.epam.javawebtraining.spalaukou.task06.model.logic.builder.SAXBuilder;

import by.epam.javawebtraining.spalaukou.task06.model.entity.voucher.TouristVoucher;
import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.AbstractToursBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

public class SAXBuilder extends AbstractToursBuilder {
    private Set<TouristVoucher> touristVouchers;
    private TouristVoucherHandler sh;
    private XMLReader reader;

    public SAXBuilder() {
        // creating SAX-analyzer
        sh = new TouristVoucherHandler();
        try {
            // creating handler object
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(sh);
        } catch (SAXException e) {
            System.err.print("SAX parser Error: " + e);
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
            System.err.print("SAX parser Error: " + e);
        } catch (IOException e) {
            System.err.print("I/O stream Error: " + e);
        }
        touristVouchers = sh.getTouristVouchers();
    }
}
