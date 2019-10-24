package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The type Street.
 */
@Entity
public class Street {

    @Id
    @GeneratedValue
    private Integer streetId;

    private String streetName;

    /**
     * Gets street id.
     *
     * @return the street id
     */
    public Integer getStreetId() {
        return streetId;
    }

    /**
     * Sets street id.
     *
     * @param streetId the street id
     */
    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    /**
     * Gets street name.
     *
     * @return the street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets street name.
     *
     * @param streetName the street name
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    /**
     * Instantiates a new Street.
     */
    public Street() {
    }

    /**
     * Instantiates a new Street.
     *
     * @param streetName the street name
     */
    public Street(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return "Street{" +
                "streetId=" + streetId +
                ", streetName='" + streetName + '\'' +
                '}';
    }
}