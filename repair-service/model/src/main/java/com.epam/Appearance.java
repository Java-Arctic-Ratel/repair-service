package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Appearance {

    /**
     * Appearance id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer appearanceId;

    private  String appearanceName;

    /**
     * Device condition id is the foreign key (Appearance to device condition).
     */
    private Integer deviceConditionId;

    /**
     * Constructor without parameters.
     */
    public Appearance() {
    }

    /**
     * Constructor with parameters.
     *
     * @param appearanceName Appearance name.
     * @param deviceConditionId Device condition id.
     */
    public Appearance(String appearanceName, Integer deviceConditionId) {
        this.appearanceName = appearanceName;
        this.deviceConditionId = deviceConditionId;
    }

    public Integer getAppearanceId() {
        return appearanceId;
    }

    public void setAppearanceId(Integer appearanceId) {
        this.appearanceId = appearanceId;
    }

    public String getAppearanceName() {
        return appearanceName;
    }

    public void setAppearanceName(String appearanceName) {
        this.appearanceName = appearanceName;
    }

    public Integer getDeviceConditionId() {
        return deviceConditionId;
    }

    public void setDeviceConditionId(Integer deviceConditionId) {
        this.deviceConditionId = deviceConditionId;
    }
}
