package by.epam.javawebtraining.spalaukou.task06.model.entity.voucher;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "touristVouchers", propOrder = {
        "touristVoucher"
})
public class TouristVouchers {
    @XmlElement(required = true)
    private List<TouristVoucher> touristVoucher;

    public List<TouristVoucher> getTouristVoucher() {
        return touristVoucher;
    }

    public void setTouristVoucher(List<TouristVoucher> touristVoucher) {
        this.touristVoucher = touristVoucher;
    }
}
