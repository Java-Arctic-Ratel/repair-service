package com.epam;

public class LastName {

    private Integer lastNameId;

    private String lastName;

    public Integer getLastNameId() {
        return lastNameId;
    }

    public void setLastNameId(Integer lastNameId) {
        this.lastNameId = lastNameId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LastName() {
    }

    public LastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "LastName{" +
                "lastNameId=" + lastNameId +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
