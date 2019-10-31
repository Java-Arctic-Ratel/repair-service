package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The type Defect.
 */
@Entity
public class Defect {

    /**
     * Defect id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer defectId;
    private  String defectName;
    /**
     * Device condition id is the foreign key (Defect to device condition).
     */
    private Integer deviceConditionId;

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

    /**
     * Gets defect name.
     *
     * @return the defect name
     */
    public String getDefectName() {
        return defectName;
    }

    /**
     * Sets defect name.
     *
     * @param defectName the defect name
     */
    public void setDefectName(String defectName) {
        this.defectName = defectName;
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

    @Override
    public String toString() {
        return "Defect{" +
                "defectId=" + defectId +
                ", defectName='" + defectName + '\'' +
                ", deviceConditionId=" + deviceConditionId +
                '}';
    }
}
