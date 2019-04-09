package by.epam.javawebtraining.spalaukou.task06.model.logic.builder;

import by.epam.javawebtraining.spalaukou.task06.model.entity.voucher.TouristVoucher;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Stanislau Palaukou on 09.04.2019
 * @project task06
 */

public abstract class AbstractToursBuilder {

    protected Set<TouristVoucher> touristVouchers;

    public AbstractToursBuilder() {
        touristVouchers = new HashSet<>();
    }

    public AbstractToursBuilder(Set<TouristVoucher> touristVouchers) {
        this.touristVouchers = touristVouchers;
    }

    public Set<TouristVoucher> getTouristVouchers() {
        return touristVouchers;
    }

    abstract public void buildSetTours(String fileName);
}