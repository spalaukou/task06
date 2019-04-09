package by.epam.javawebtraining.spalaukou.task06.model.entity.voucher;

import javax.xml.bind.annotation.*;

/**
 * @author Stanislau Palaukou on 07.04.2019
 * @project task06
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hotelCharacteristics", propOrder = {
        "stars",
        "meals",
        "persons",
        "TV",
        "condition",
        "pool",
        "freeWiFi"
})
public class HotelCharacteristics {
    @XmlSchemaType(name = "positiveInteger")
    private int stars;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    private Meals meals;
    @XmlSchemaType(name = "positiveInteger")
    private int persons;
    @XmlElement(name = "TV", required = true)
    private String TV;
    @XmlElement(name = "condition", required = true)
    private String condition;
    @XmlElement(name = "pool", required = true)
    private String pool;
    @XmlElement(name = "freeWiFi", required = true)
    private String freeWiFi;

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Meals getMeals() {
        return meals;
    }

    public void setMeals(Meals meals) {
        this.meals = meals;
    }

    public int getPersons() {
        return persons;
    }

    public void setPersons(int persons) {
        this.persons = persons;
    }

    public String getTV() {
        return TV;
    }

    public void setTV(String TV) {
        this.TV = TV;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPool() {
        return pool;
    }

    public void setPool(String pool) {
        this.pool = pool;
    }

    public String getFreeWiFi() {
        return freeWiFi;
    }

    public void setFreeWiFi(String freeWiFi) {
        this.freeWiFi = freeWiFi;
    }

    @Override
    public String toString() {
        return "\n\t\tHotelCharacteristics{" +
                "\n\t\tstars=" + stars +
                ", \n\t\tmeals=" + meals +
                ", \n\t\tpersons=" + persons +
                ", \n\t\tTV='" + TV + '\'' +
                ", \n\t\tcondition='" + condition + '\'' +
                ", \n\t\tpool='" + pool + '\'' +
                ", \n\t\tfreeWiFi='" + freeWiFi + '\'' +
                '}';
    }
}
