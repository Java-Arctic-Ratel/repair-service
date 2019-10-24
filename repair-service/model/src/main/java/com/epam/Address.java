package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The type Address.
 */
@Entity
public class Address {

    @Id
    @GeneratedValue
    private Integer addressId;

    private String houseNumber;

    private String apartmentNumber;

    private Integer clientAddressId;

    private Integer cityId;

    private Integer streetId;

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
     * Gets client address id.
     *
     * @return the client address id
     */
    public Integer getClientAddressId() {
        return clientAddressId;
    }

    /**
     * Sets client address id.
     *
     * @param clientAddressId the client address id
     */
    public void setClientAddressId(Integer clientAddressId) {
        this.clientAddressId = clientAddressId;
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
     * Instantiates a new Address.
     */
    public Address() {
    }

    /**
     * Instantiates a new Address.
     *
     * @param houseNumber     the house number
     * @param apartmentNumber the apartment number
     * @param clientAddressId the client address id
     * @param cityId          the city id
     * @param streetId        the street id
     */
    public Address(String houseNumber, String apartmentNumber, Integer clientAddressId, Integer cityId, Integer streetId) {
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.clientAddressId = clientAddressId;
        this.cityId = cityId;
        this.streetId = streetId;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", houseNumber='" + houseNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", clientAddressId=" + clientAddressId +
                ", cityId=" + cityId +
                ", streetId=" + streetId +
                '}';
    }
}
