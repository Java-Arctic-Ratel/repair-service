package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The type Appearance.
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
     * Device condition id is the foreign key (Complectation to device condition).
     */
    private Integer deviceConditionId;

    /**
     * Constructor without parameters.
     */
    public Complectation() {
    }

    /**
     * Constructor with parameters.
     *
     * @param complectationName Complectation name.
     * @param deviceConditionId Device condition id.
     */
    public Complectation(String complectationName, Integer deviceConditionId) {
        this.complectationName = complectationName;
        this.deviceConditionId = deviceConditionId;
    }

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

    /**
     * Gets device condition id.
     *
     * @return the device condition id
     */
    public Integer getDeviceConditionId() {
        return deviceConditionId;
    }

    /**
     * Sets device condition id.
     *
     * @param deviceConditionId the device condition id
     */
    public void setDeviceConditionId(Integer deviceConditionId) {
        this.deviceConditionId = deviceConditionId;
    }
}
