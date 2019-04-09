package by.epam.javawebtraining.spalaukou.task06.model.entity.voucher;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

@XmlType(name = "currency")
@XmlEnum
public enum Currency {
    @XmlEnumValue("usd")
    USD("usd"),
    @XmlEnumValue("eur")
    EUR("eur"),
    @XmlEnumValue("bp")
    BP("bp"),
    @XmlEnumValue("byn")
    BYN("byn"),
    @XmlEnumValue("rub")
    RUB("rub"),
    @XmlEnumValue("uah")
    UAH("uah");

    private final String value;

    public String getValue() {
        return value;
    }

    Currency(String v) {
        value = v;
    }
}
