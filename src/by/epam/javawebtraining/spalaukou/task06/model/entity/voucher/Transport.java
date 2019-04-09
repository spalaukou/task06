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
public enum Transport {
    @XmlEnumValue("car")
    CAR("car"),
    @XmlEnumValue("bus")
    BUS("bus"),
    @XmlEnumValue("railway")
    RAILWAY("railway"),
    @XmlEnumValue("flight")
    FLIGHT("flight");

    private final String value;

    Transport(String v) {
        value = v;
    }

}

