package com.epam.repair.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The type First name.
 */
@Entity
public class FirstName {

    /**
     * Device condition id is the primary key.
     */
    @Id
    @GeneratedValue
    private Integer firstNameId;
    private String firstName;

    /**
     * Gets first name id.
     *
     * @return the first name id
     */
    public Integer getFirstNameId() {
        return firstNameId;
    }

    /**
     * Sets first name id.
     *
     * @param firstNameId the first name id
     */
    public void setFirstNameId(Integer firstNameId) {
        this.firstNameId = firstNameId;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
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
