package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The type Brand.
 */
@Entity
public class Brand {

    /**
     * Brand id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer brandId;

    private  String brandName;

    /**
     * Device id is the foreign key (Brand to device).
     */
    private Integer deviceId;

    /**
     * Constructor without parameters.
     */
    public Brand() {
    }

    /**
     * Constructor with parameters.
     *
     * @param brandName the brand name
     * @param deviceId  the device id
     */
    public Brand(String brandName, Integer deviceId) {
        this.brandName = brandName;
        this.deviceId = deviceId;
    }

    /**
     * Gets brand id.
     *
     * @return the brand id
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * Sets brand id.
     *
     * @param brandId the brand id
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * Gets brand name.
     *
     * @return the brand name
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Sets brand name.
     *
     * @param brandName the brand name
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * Gets device id.
     *
     * @return the device id
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * Sets device id.
     *
     * @param deviceId the device id
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }
}
