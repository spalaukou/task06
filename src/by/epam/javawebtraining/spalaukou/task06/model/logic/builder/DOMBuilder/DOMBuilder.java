package by.epam.javawebtraining.spalaukou.task06.model.logic.builder.DOMBuilder;

import by.epam.javawebtraining.spalaukou.task06.model.entity.voucher.*;
import by.epam.javawebtraining.spalaukou.task06.model.logic.builder.AbstractToursBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Stanislau Palaukou on 08.04.2019
 * @project task06
 */

public class DOMBuilder extends AbstractToursBuilder {
    private Set<TouristVoucher> touristVouchers;
    private DocumentBuilder docBuilder;

    public DOMBuilder() {
        this.touristVouchers = new HashSet<>();
        // creating DOM-analyzer
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            System.err.println("Parser configuration Error: " + e);
        }
    }

    public Set<TouristVoucher> getTouristVouchers() {
        return touristVouchers;
    }

    @Override
    public void buildSetTours(String fileName) {
        Document doc = null;
        try {
            // parsing XML-document and creating tree-structure
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            // getting list of <touristVoucher> children elements
            NodeList vouchersList = root.getElementsByTagName("touristVoucher");
            for (int i = 0; i < vouchersList.getLength(); i++) {
                Element voucherElement = (Element) vouchersList.item(i);
                TouristVoucher touristVoucher = buildVoucher(voucherElement);
                touristVouchers.add(touristVoucher);
            }
        } catch (IOException e) {
            System.err.println("File error or I/O error: " + e);
        } catch (SAXException e) {
            System.err.println("Parsing failure: " + e);
        }
    }

    private TouristVoucher buildVoucher(Element voucherElement) {
        TouristVoucher touristVoucher = new TouristVoucher();
        // setting touristVoucher
        touristVoucher.setId(voucherElement.getAttribute("id"));

        String type = String.valueOf(getElementTextContent(voucherElement, "type"));
        touristVoucher.setType(Type.valueOf(type.toUpperCase()));

        String country = String.valueOf(getElementTextContent(voucherElement, "country"));
        touristVoucher.setCountry(country);

        String city = String.valueOf(getElementTextContent(voucherElement, "city"));
        touristVoucher.setCity(city);

        BigInteger numberNights = BigInteger.valueOf(Integer.parseInt(getElementTextContent(
                voucherElement, "numberNights")));
        touristVoucher.setNumberNights(numberNights);

        String transport = String.valueOf(getElementTextContent(voucherElement, "transport"));
        touristVoucher.setTransport(Transport.valueOf(transport.toUpperCase()));

        HotelCharacteristics hotelCharacteristics = new HotelCharacteristics();
        // setting hotelCharacteristics
        Integer stars = Integer.parseInt(getElementTextContent(voucherElement, "stars"));
        hotelCharacteristics.setStars(stars);

        String meals = getElementTextContent(voucherElement, "meals");
        hotelCharacteristics.setMeals(Meals.valueOf(meals));

        String persons = getElementTextContent(voucherElement, "persons");
        hotelCharacteristics.setPersons(Integer.valueOf(persons));

        String tv = getElementTextContent(voucherElement, "TV");
        hotelCharacteristics.setTV(tv);

        String condition = getElementTextContent(voucherElement, "condition");
        hotelCharacteristics.setCondition(condition);

        String pool = getElementTextContent(voucherElement, "pool");
        hotelCharacteristics.setPool(pool);

        String freeWiFi = getElementTextContent(voucherElement, "freeWiFi");
        hotelCharacteristics.setFreeWiFi(freeWiFi);

        touristVoucher.setHotelCharacteristics(hotelCharacteristics);

        Price price = new Price();
        // setting price
        Element priceElement = (Element) voucherElement.getElementsByTagName(
                "cost").item(0);
        price.setCurrency(Currency.valueOf(priceElement.getAttribute("currency")));

        String cost = getElementTextContent(voucherElement, "cost");
        price.setValue(new BigDecimal(cost));

        touristVoucher.setCost(price);

        return touristVoucher;
    }

    // getting text content of tag
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
