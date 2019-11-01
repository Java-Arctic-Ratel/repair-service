package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * The type Defect.
 */
@Entity
@Table(name = "defect")
public class Defect {

    /**
     * Defect id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="defect_generator")
    @SequenceGenerator(name="defect_generator",
            sequenceName="defect_generator", allocationSize=1000)
    @Column(name="defect_id", updatable=false, nullable=false)
    private Integer defectId;

    @Column(name="defect_name", length = 40, nullable=false)
    private  String defectName;

    @JsonIgnore
    @OneToMany(mappedBy="defect")
    private List<DeviceCondition> deviceConditions;

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
     * Gets device conditions.
     *
     * @return the device conditions
     */
    public List<DeviceCondition> getDeviceConditions() {
        return deviceConditions;
    }

    /**
     * Sets device conditions.
     *
     * @param deviceConditions the device conditions
     */
    public void setDeviceConditions(List<DeviceCondition> deviceConditions) {
        this.deviceConditions = deviceConditions;
    }

    @Override
    public String toString() {
        return "Defect{" +
                "defectId=" + defectId +
                ", defectName='" + defectName + '\'' +
                '}';
    }
}
