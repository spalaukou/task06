package by.epam.javawebtraining.spalaukou.task06.model.logic.builder.SAXBuilder;

import by.epam.javawebtraining.spalaukou.task06.model.entity.voucher.*;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

public class TouristVoucherHandler extends DefaultHandler {
    private Set<TouristVoucher> touristVouchers;
    private TouristVoucher current = null;
    private TourEnum currentEnum = null;
    private Price currentPrice;
    private HotelCharacteristics currentHotelCharacteristics;
    private EnumSet<TourEnum> withText;

    public TouristVoucherHandler() {
        touristVouchers = new HashSet<>();
        withText = EnumSet.range(TourEnum.TYPE, TourEnum.COUNTRY);
    }

    public Set<TouristVoucher> getTouristVouchers() {
        return touristVouchers;
    }

    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        switch (qName){
            case "touristVoucher":
                current = new TouristVoucher();
                current.setId(attrs.getValue(0));
                break;
            case "type": currentEnum = TourEnum.TYPE; break;
            case "country": currentEnum = TourEnum.COUNTRY; break;
            case "city": currentEnum = TourEnum.CITY; break;
            case "numberNights": currentEnum = TourEnum.NUMBERNIGHTS; break;
            case "transport": currentEnum = TourEnum.TRANSPORT; break;
            case "hotelCharacteristics": currentHotelCharacteristics = new HotelCharacteristics(); break;
            case "stars": currentEnum = TourEnum.STARS; break;
            case "meals": currentEnum = TourEnum.MEALS; break;
            case "persons": currentEnum = TourEnum.PERSONS; break;
            case "TV": currentEnum = TourEnum.TV; break;
            case "condition": currentEnum = TourEnum.CONDITION; break;
            case "pool": currentEnum = TourEnum.POOL; break;
            case "freeWiFi": currentEnum = TourEnum.FREEWIFI; break;
            case "cost":
                currentPrice = new Price();
                currentPrice.setCurrency(Currency.valueOf(attrs.getValue(0)));
                currentEnum = TourEnum.COST;
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) {
        switch (qName){
            case "touristVoucher": touristVouchers.add(current); break;
            case "cost": current.setCost(currentPrice); break;
            case "hotelCharacteristics": current.setHotelCharacteristics(currentHotelCharacteristics); break;
        }
    }

    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case TYPE: current.setType(Type.valueOf(s.toUpperCase())); break;
                case COUNTRY: current.setCountry(s); break;
                case CITY: current.setCity(s); break;
                case NUMBERNIGHTS: current.setNumberNights(Integer.parseInt(s)); break;
                case TRANSPORT: current.setTransport(Transport.valueOf(s.toUpperCase())); break;
                case STARS: currentHotelCharacteristics.setStars(Integer.valueOf(s)); break;
                case MEALS: currentHotelCharacteristics.setMeals(Meals.valueOf(s)); break;
                case PERSONS: currentHotelCharacteristics.setPersons(Integer.valueOf(s)); break;
                case TV: currentHotelCharacteristics.setTV(s); break;
                case CONDITION: currentHotelCharacteristics.setCondition(s); break;
                case POOL: currentHotelCharacteristics.setPool(s); break;
                case FREEWIFI: currentHotelCharacteristics.setFreeWiFi(s); break;
                case COST: currentPrice.setValue(new BigDecimal(s)); break;
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}

