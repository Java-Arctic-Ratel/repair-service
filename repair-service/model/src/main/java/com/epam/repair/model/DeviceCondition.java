package com.epam.repair.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The type DeviceCondition.
 */
@Entity
public class DeviceCondition {

    /**
     * Device condition id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer deviceConditionId;
    /**
     * Appearance Id id is the foreign key (Appearance id to device condition).
     */
    private Integer appearanceId;
    /**
     * Complectation Id id is the foreign key (Complectation id to device condition).
     */
    private Integer сomplectationId;
    /**
     * Defect Id id is the foreign key (Defect id to device condition).
     */
    private Integer defectId;

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

    /**
     * Gets appearance id.
     *
     * @return the appearance id
     */
    public Integer getAppearanceId() {
        return appearanceId;
    }

    /**
     * Sets appearance id.
     *
     * @param appearanceId the appearance id
     */
    public void setAppearanceId(Integer appearanceId) {
        this.appearanceId = appearanceId;
    }

    /**
     * Get сomplectation id integer.
     *
     * @return the integer
     */
    public Integer getСomplectationId() {
        return сomplectationId;
    }

    /**
     * Set сomplectation id.
     *
     * @param сomplectationId the сomplectation id
     */
    public void setСomplectationId(Integer сomplectationId) {
        this.сomplectationId = сomplectationId;
    }

    /**
     * Gets defect id.
     *
     * @return the defect id
     */
    public Integer getDefectId() {
        return defectId;
    }

    /**
     * Sets defect id.
     *
     * @param defectId the defect id
     */
    public void setDefectId(Integer defectId) {
        this.defectId = defectId;
    }

    @Override
    public String toString() {
        return "DeviceCondition{" +
                "deviceConditionId=" + deviceConditionId +
                ", appearanceId=" + appearanceId +
                ", сomplectationId=" + сomplectationId +
                ", defectId=" + defectId +
                '}';
    }
}