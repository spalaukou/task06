package by.epam.javawebtraining.spalaukou.task06.model.entity.voucher;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

@XmlType(name = "transport")
@XmlEnum

public enum Meals {
    @XmlEnumValue("BB")
    BB("BB"),

    @XmlEnumValue("HB")
    HB("HB"),

    @XmlEnumValue("FB")
    FB("FB"),

    @XmlEnumValue("AI")
    AI("AI"),

    @XmlEnumValue("UAI")
    UAI("UAI");

    private final String value;

    Meals(String v) {
        value = v;
    }
}
