package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * The type City.
 */
@Entity
@Table(name = "city")
public class City {

    /**
     * City id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="city_generator")
    @SequenceGenerator(name="city_generator",
            sequenceName="city_generator", allocationSize=1000)
    @Column(name="city_id", updatable=false, nullable=false)
    private Integer cityId;

    @Column(name="city_name", length = 40, nullable=false)
    private String cityName;

    @JsonIgnore
    @OneToMany(mappedBy="city")
    private List<Address> address;

    /**
     * Gets address.
     *
     * @return the address
     */
    public List<Address> getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(List<Address> address) {
        this.address = address;
    }

    /**
     * Gets city id.
     *
     * @return the city id
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * Sets city id.
     *
     * @param cityId the city id
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * Gets city name.
     *
     * @return the city name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets city name.
     *
     * @param cityName the city name
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
