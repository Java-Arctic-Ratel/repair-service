package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The type Last name.
 */
@Entity
public class LastName {

    @Id
    @GeneratedValue
    private Integer lastNameId;

    private String lastName;

    /**
     * Gets last name id.
     *
     * @return the last name id
     */
    public Integer getLastNameId() {
        return lastNameId;
    }

    /**
     * Sets last name id.
     *
     * @param lastNameId the last name id
     */
    public void setLastNameId(Integer lastNameId) {
        this.lastNameId = lastNameId;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Instantiates a new Last name.
     */
    public LastName() {
    }

    /**
     * Instantiates a new Last name.
     *
     * @param lastName the last name
     */
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
