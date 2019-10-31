package com.epam.repair.model;

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

    @Override
    public String toString() {
        return "Defect{" +
                "defectId=" + defectId +
                ", defectName='" + defectName + '\'' +
                '}';
    }
}
