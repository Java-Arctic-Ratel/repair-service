package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The type Appearance.
 */
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
     * @param appearanceName    Appearance name.
     * @param deviceConditionId Device condition id.
     */
    public Appearance(String appearanceName, Integer deviceConditionId) {
        this.appearanceName = appearanceName;
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
     * Gets appearance name.
     *
     * @return the appearance name
     */
    public String getAppearanceName() {
        return appearanceName;
    }

    /**
     * Sets appearance name.
     *
     * @param appearanceName the appearance name
     */
    public void setAppearanceName(String appearanceName) {
        this.appearanceName = appearanceName;
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
