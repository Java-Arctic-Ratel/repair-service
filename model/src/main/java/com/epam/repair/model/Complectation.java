package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * The type Complectation.
 */
@Entity
@Table(name = "complectation")
public class Complectation {

    /**
     * Complectation id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="complectation_generator")
    @SequenceGenerator(name="complectation_generator",
            sequenceName="complectation_generator", allocationSize=1000)
    @Column(name="complectation_id", updatable=false, nullable=false)
    private Integer complectationId;

    @Column(name="complectation_name", length = 40, nullable=false)
    private  String complectationName;

    @JsonIgnore
    @OneToMany(mappedBy="complectation")
    private List<DeviceCondition> deviceConditions;

    /**
     * Gets complectation id.
     *
     * @return the complectation id
     */
    public Integer getComplectationId() {
        return complectationId;
    }

    /**
     * Sets complectation id.
     *
     * @param complectationId the complectation id
     */
    public void setComplectationId(Integer complectationId) {
        this.complectationId = complectationId;
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
        return "Complectation{" +
                "complectationId=" + complectationId +
                ", complectationName='" + complectationName + '\'' +
                '}';
    }
}
