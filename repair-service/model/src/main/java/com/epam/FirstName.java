package com.epam;

public class FirstName {

    private Integer firstNameId;

    private String firstName;

    public Integer getFirstNameId() {
        return firstNameId;
    }

    public void setFirstNameId(Integer firstNameId) {
        this.firstNameId = firstNameId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public FirstName() {
    }

    public FirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "FirstName{" +
                "firstNameId=" + firstNameId +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
