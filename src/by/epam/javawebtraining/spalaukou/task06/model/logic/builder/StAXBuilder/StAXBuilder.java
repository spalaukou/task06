package by.epam.javawebtraining.spalaukou.task06.model.logic.builder.StAXBuilder;

import by.epam.javawebtraining.spalaukou.task06.model.entity.voucher.*;
import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.AbstractToursBuilder;
import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.SAXBuilder.SAXBuilder;
import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.SAXBuilder.TourEnum;
import org.apache.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author Stanislau Palaukou on 09.04.2019
 * @project task06
 */

public class StAXBuilder extends AbstractToursBuilder {
    private static final Logger LOGGER = Logger.getRootLogger();
    private static StAXBuilder instance;
    private XMLInputFactory inputFactory;

    public static StAXBuilder getInstance() {
        if (instance == null) {
            instance = new StAXBuilder();
            return instance;
        }
        else {
            return instance;
        }
    }

    private StAXBuilder() {
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetTours(String fileName) {
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (TourEnum.valueOf(name.toUpperCase()) == TourEnum.TOURISTVOUCHER) {
                        TouristVoucher touristVoucher = buildTouristVoucher(reader);
                        touristVouchers.add(touristVoucher);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            LOGGER.error("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            LOGGER.error("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("Impossible close file "+fileName+" : "+e);
            }
        }
    }

    private TouristVoucher buildTouristVoucher(XMLStreamReader reader) throws XMLStreamException {
        TouristVoucher touristVoucher = new TouristVoucher();
        touristVoucher.setId(reader.getAttributeValue(null, TourEnum.ID.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TourEnum.valueOf(name.toUpperCase())) {
                        case TYPE: touristVoucher.setType(Type.valueOf(getXMLText(reader).toUpperCase())); break;
                        case COUNTRY: touristVoucher.setCountry(getXMLText(reader)); break;
                        case CITY: touristVoucher.setCity(getXMLText(reader)); break;
                        case NUMBERNIGHTS: touristVoucher.setNumberNights(BigInteger.valueOf(
                                Integer.parseInt(getXMLText(reader)))); break;
                        case TRANSPORT: touristVoucher.setTransport(Transport.valueOf(
                                getXMLText(reader).toUpperCase())); break;
                        case HOTELCHARACTERISTICS: touristVoucher.setHotelCharacteristics(
                                getXMLHotelCharacteristics(reader)); break;
                        case COST: touristVoucher.setCost(getXMLCost(reader)); break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TourEnum.valueOf(name.toUpperCase()) == TourEnum.TOURISTVOUCHER) {
                        return touristVoucher;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag TouristVoucher");
    }

    private HotelCharacteristics getXMLHotelCharacteristics(XMLStreamReader reader) throws XMLStreamException {
        HotelCharacteristics hotelCharacteristics = new HotelCharacteristics();
        int type;
        String name;
        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TourEnum.valueOf(name.toUpperCase())) {
                        case STARS: hotelCharacteristics.setStars(Integer.parseInt(getXMLText(reader))); break;
                        case MEALS: hotelCharacteristics.setMeals(Meals.valueOf(getXMLText(reader).toUpperCase())); break;
                        case PERSONS: hotelCharacteristics.setPersons(Integer.parseInt(getXMLText(reader))); break;
                        case TV: hotelCharacteristics.setTV(getXMLText(reader)); break;
                        case CONDITION: hotelCharacteristics.setCondition(getXMLText(reader)); break;
                        case POOL: hotelCharacteristics.setPool(getXMLText(reader)); break;
                        case FREEWIFI: hotelCharacteristics.setFreeWiFi(getXMLText(reader)); break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (TourEnum.valueOf(name.toUpperCase()) == TourEnum.HOTELCHARACTERISTICS){
                        return hotelCharacteristics;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag HotelCharacteristics");
    }

    private Price getXMLCost(XMLStreamReader reader) throws XMLStreamException {
        Price price = new Price();
        price.setCurrency(Currency.valueOf(
                reader.getAttributeValue(null, "currency").toUpperCase()));
        price.setValue(new BigDecimal(getXMLText(reader)));

        return price;
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
