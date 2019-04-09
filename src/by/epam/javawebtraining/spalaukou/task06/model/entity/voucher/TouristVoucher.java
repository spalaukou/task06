package by.epam.javawebtraining.spalaukou.task06.model.entity.voucher;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigInteger;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "touristVoucher", propOrder = {
        "type",
        "country",
        "city",
        "numberNights",
        "transport",
        "hotelCharacteristics",
        "cost"
})
public class TouristVoucher {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    private Type type;
    @XmlElement(required = true)
    private String country;
    @XmlElement(required = true)
    private String city;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    private BigInteger numberNights;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    private Transport transport;
    @XmlElement(required = true)
    private HotelCharacteristics hotelCharacteristics;
    @XmlElement(required = true)
    private Price cost;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")

    private String id;

    public TouristVoucher() {
    }

    public TouristVoucher(Type type, String country, String city, BigInteger numberNights, Transport transport,
                          HotelCharacteristics hotelCharacteristics, Price cost, String id) {
        this.type = type;
        this.country = country;
        this.city = city;
        this.numberNights = numberNights;
        this.transport = transport;
        this.hotelCharacteristics = hotelCharacteristics;
        this.cost = cost;
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigInteger getNumberNights() {
        return numberNights;
    }

    public void setNumberNights(BigInteger numberNights) {
        this.numberNights = numberNights;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public HotelCharacteristics getHotelCharacteristics() {
        return hotelCharacteristics;
    }

    public void setHotelCharacteristics(HotelCharacteristics hotelCharacteristics) {
        this.hotelCharacteristics = hotelCharacteristics;
    }

    public Price getCost() {
        return cost;
    }

    public void setCost(Price cost) {
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nTouristVoucher{" +
                "\n\tid='" + id + '\'' +
                "\n\ttype=" + type +
                ", \n\tcountry='" + country + '\'' +
                ", \n\tcity='" + city + '\'' +
                ", \n\tnumberNights=" + numberNights +
                ", \n\ttransport=" + transport +
                ", \n\thotelCharacteristics=" + hotelCharacteristics +
                ", \n\tcost=" + cost +
                '}';
    }
}
