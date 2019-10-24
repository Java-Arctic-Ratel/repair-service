package com.epam;

public class Address {

    private Integer addressId;

    private String houseNumber;

    private String apartmentNumber;

    private Integer clientAddressId;

    private Integer cityId;

    private Integer streetId;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Integer getClientAddressId() {
        return clientAddressId;
    }

    public void setClientAddressId(Integer clientAddressId) {
        this.clientAddressId = clientAddressId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public Address() {
    }

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
