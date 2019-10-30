package com.epam.repair.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Class represents entity with device information of repairing service.
 */
@Entity
public class Device {

    /**
     * Device id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer deviceId;
    private String deviceIMEIOrSn;
    private String devicePassword;
    /**
     * Client id is the foreign key (Client to device).
     */
    private Integer clientId;
    /**
     * Device condition id is the foreign key (Device condition to device).
     */
    private Integer deviceConditionId;
    /**
     * Model id is the foreign key (Model to device).
     */
    private Integer modelId;
    /**
     * Brand id is the foreign key (Brand to device).
     */
    private Integer brandId;

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

    /**
     * Gets device imei or sn.
     *
     * @return the device imei or sn
     */
    public String getDeviceIMEIOrSn() {
        return deviceIMEIOrSn;
    }

    /**
     * Sets device imei or sn.
     *
     * @param deviceIMEIOrSn the device imei or sn
     */
    public void setDeviceIMEIOrSn(String deviceIMEIOrSn) {
        this.deviceIMEIOrSn = deviceIMEIOrSn;
    }

    /**
     * Gets device password.
     *
     * @return the device password
     */
    public String getDevicePassword() {
        return devicePassword;
    }

    /**
     * Sets device password.
     *
     * @param devicePassword the device password
     */
    public void setDevicePassword(String devicePassword) {
        this.devicePassword = devicePassword;
    }

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * Sets client id.
     *
     * @param clientId the client id
     */
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
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

    /**
     * Gets model id.
     *
     * @return the model id
     */
    public Integer getModelId() {
        return modelId;
    }

    /**
     * Sets model id.
     *
     * @param modelId the model id
     */
    public void setModelId(Integer modelId) {
        this.modelId = modelId;
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

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", deviceIMEIOrSn='" + deviceIMEIOrSn + '\'' +
                ", devicePassword='" + devicePassword + '\'' +
                ", clientId=" + clientId +
                ", deviceConditionId=" + deviceConditionId +
                ", modelId=" + modelId +
                ", brandId=" + brandId +
                '}';
    }
}
