package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * The type DeviceCondition.
 */
@Entity
@Table(name = "device_condition")
public class DeviceCondition {

    /**
     * Device condition id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="device_condition_generator")
    @SequenceGenerator(name="device_condition_generator",
            sequenceName="device_condition_generator", allocationSize=1000)
    @Column(name="device_condition_id", updatable=false, nullable=false)
    private Integer deviceConditionId;

    /**
     * Appearance id is the foreign key (Appearance to device condition).
     */
    @ManyToOne
    @JoinColumn (name="appearance_id")
    private Appearance appearance;

    /**
     * Complectation id is the foreign key (Complectation to device condition).
     */
    @ManyToOne
    @JoinColumn (name="complectation_id")
    private Complectation complectation;

    /**
     * Defect id is the foreign key (Defect to device condition).
     */
    @ManyToOne
    @JoinColumn (name="defect_id")
    private Defect defect;

    @JsonIgnore
    @OneToMany(mappedBy="deviceCondition")
    private List<Device> devices;

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
     * Gets appearance.
     *
     * @return the appearance
     */
    public Appearance getAppearance() {
        return appearance;
    }

    /**
     * Sets appearance.
     *
     * @param appearance the appearance
     */
    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    /**
     * Gets complectation.
     *
     * @return the complectation
     */
    public Complectation getComplectation() {
        return complectation;
    }

    /**
     * Sets complectation.
     *
     * @param complectation the complectation
     */
    public void setComplectation(Complectation complectation) {
        this.complectation = complectation;
    }

    /**
     * Gets defect.
     *
     * @return the defect
     */
    public Defect getDefect() {
        return defect;
    }

    /**
     * Sets defect.
     *
     * @param defect the defect
     */
    public void setDefect(Defect defect) {
        this.defect = defect;
    }

    /**
     * Gets devices.
     *
     * @return the devices
     */
    public List<Device> getDevices() {
        return devices;
    }

    /**
     * Sets devices.
     *
     * @param devices the devices
     */
    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "DeviceCondition{" +
                "deviceConditionId=" + deviceConditionId +
                ", appearance=" + appearance +
                ", complectation=" + complectation +
                ", defect=" + defect +
                '}';
    }
}
