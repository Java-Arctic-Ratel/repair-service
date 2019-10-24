package com.epam;

public class Street {

    private Integer streetId;

    private String streetName;

    public Integer getStreetId() {
        return streetId;
    }

    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public Street() {
    }

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
