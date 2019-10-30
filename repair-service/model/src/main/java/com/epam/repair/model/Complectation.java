package com.epam.repair.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The type Complectation.
 */
@Entity
public class Complectation {

    /**
     * Complectation id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer complectationId;
    private  String complectationName;

    /**
     * Gets complectation name.
     *
     * @return the complectation name
     */
    public String getComplectationName() {
        return complectationName;
    }

    /**
     * Sets complectation name.
     *
     * @param complectationName the complectation name
     */
    public void setComplectationName(String complectationName) {
        this.complectationName = complectationName;
    }

    @Override
    public String toString() {
        return "Complectation{" +
                "complectationId=" + complectationId +
                ", complectationName='" + complectationName + '\'' +
                '}';
    }
}
