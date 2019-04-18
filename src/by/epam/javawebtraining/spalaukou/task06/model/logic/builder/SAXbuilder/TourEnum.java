package by.epam.javawebtraining.spalaukou.task06.model.logic.builder.SAXbuilder;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

public enum TourEnum {
    TOURISTVOUCHER("touristVouchers"),
    TOURIST_VOUCHER("touristVoucher"),
    TYPE("type"),
    COUNTRY("country"),
    CITY("city"),
    NUMBERNIGHTS("numberNights"),
    TRANSPORT("transport"),
    HOTELCHARACTERISTICS("hotelCharacteristics"),
    STARS("stars"),
    MEALS("meals"),
    PERSONS("persons"),
    TV("TV"),
    CONDITION("condition"),
    POOL("pool"),
    FREEWIFI("freeWiFi"),
    COST("cost"),
    ID("id"),
    TOURS("tours");

    private String value;

    private TourEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
