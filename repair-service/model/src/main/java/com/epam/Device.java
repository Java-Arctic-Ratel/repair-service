package com.epam;

import javax.swing.*;

/**
 * Class represents entity with device information of repairing service.
 */
public class Device {

    private Integer deviceId;

    private String deviceIMEIOrSn;

    private String devicePassword;

    private Integer clientId;

    private Integer orderId;

    private Integer deviceConditionId;

    private Integer modelId;

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
     * Gets order id.
     *
     * @return the order id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * Sets order id.
     *
     * @param orderId the order id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
                ", orderId=" + orderId +
                ", deviceConditionId=" + deviceConditionId +
                ", modelId=" + modelId +
                ", brandId=" + brandId +
                '}';
    }
}
