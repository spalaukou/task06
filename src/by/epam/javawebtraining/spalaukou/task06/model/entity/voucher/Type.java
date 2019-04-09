package by.epam.javawebtraining.spalaukou.task06.model.entity.voucher;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

@XmlType(name = "type")
@XmlEnum
public enum Type {
    @XmlEnumValue("rest")
    REST("rest"),
    @XmlEnumValue("excursion")
    EXCURSION("excursion"),
    @XmlEnumValue("weekend")
    WEEKEND("weekend"),
    @XmlEnumValue("gastroTour")
    GASTROTOUR("gastroTour"),
    @XmlEnumValue("pilgrimage")
    PILGRIMAGE("pilgrimage");

    private final String value;

    public String getValue() {
        return value;
    }

    Type(String v) {
        value = v;
    }

}

