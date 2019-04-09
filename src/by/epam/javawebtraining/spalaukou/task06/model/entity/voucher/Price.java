package by.epam.javawebtraining.spalaukou.task06.model.entity.voucher;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "price", propOrder = {
        "value",
        "currency"
})
public class Price {
    @XmlValue
    private BigDecimal value;
    @XmlAttribute(name = "string")
    private Currency currency;

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "\n\t\tPrice{" +
                "\n\t\tvalue=" + value +
                ", \n\t\tcurrency=" + currency +
                '}';
    }
}
