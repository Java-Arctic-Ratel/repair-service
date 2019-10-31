package com.epam.repair.model;

import javax.persistence.*;

/**
 * The type Address.
 */
@Entity
@Table(name = "address")
public class Address {

    /**
     * City id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="address_generator")
    @SequenceGenerator(name="address_generator",
            sequenceName="address_generator", allocationSize=1000)
    @Column(name="address_id", updatable=false, nullable=false)
    private Integer addressId;

    @Column(name="address_number_house", length = 40, nullable=false)
    private String houseNumber;

    @Column(name="address_number_apartment", length = 40, nullable=false)
    private String apartmentNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="city_id")
    private City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn (name="street_id")
    private Street street;

    /**
     * Gets address id.
     *
     * @return the address id
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * Sets address id.
     *
     * @param addressId the address id
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * Gets house number.
     *
     * @return the house number
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Sets house number.
     *
     * @param houseNumber the house number
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Gets apartment number.
     *
     * @return the apartment number
     */
    public String getApartmentNumber() {
        return apartmentNumber;
    }

    /**
     * Sets apartment number.
     *
     * @param apartmentNumber the apartment number
     */
    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public City getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * Gets street.
     *
     * @return the street
     */
    public Street getStreet() {
        return street;
    }

    /**
     * Sets street.
     *
     * @param street the street
     */
    public void setStreet(Street street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", houseNumber='" + houseNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", city=" + city +
                ", street=" + street +
                '}';
    }
}
