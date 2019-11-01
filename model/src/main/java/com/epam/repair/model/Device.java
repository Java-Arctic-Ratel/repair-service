package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * Class represents entity with device information of repairing service.
 */
@Entity
@Table(name = "device")
public class Device {

    /**
     * Device id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="device_generator")
    @SequenceGenerator(name="device_generator",
            sequenceName="device_generator", allocationSize=1000)
    @Column(name="device_id", updatable=false, nullable=false)
    private Integer deviceId;

    @Column(name="device_imei_or_sn", length = 40, nullable=false)
    private String deviceIMEIOrSn;

    @Column(name="device_password", length = 40, nullable=false)
    private String devicePassword;

    /**
     * Client id is the foreign key (Client to device).
     */
    @ManyToOne
    @JoinColumn (name="client_id")
    private Client client;

    /**
     * Device condition id is the foreign key (Device condition to device).
     */
    @ManyToOne
    @JoinColumn (name="device_condition_id")
    private DeviceCondition deviceCondition;

    /**
     * Model id is the foreign key (Model to device).
     */
    @ManyToOne
    @JoinColumn (name="model_id")
    private Model model;

    /**
     * Brand id is the foreign key (Brand to device).
     */
    @ManyToOne
    @JoinColumn (name="brand_id")
    private Brand brand;

    @JsonIgnore
    @OneToMany(mappedBy="device")
    private List<Orders> orders;

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
     * Gets client.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets client.
     *
     * @param client the client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Gets device condition.
     *
     * @return the device condition
     */
    public DeviceCondition getDeviceCondition() {
        return deviceCondition;
    }

    /**
     * Sets device condition.
     *
     * @param deviceCondition the device condition
     */
    public void setDeviceCondition(DeviceCondition deviceCondition) {
        this.deviceCondition = deviceCondition;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public Model getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Gets brand.
     *
     * @return the brand
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * Sets brand.
     *
     * @param brand the brand
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * Gets orders.
     *
     * @return the orders
     */
    public List<Orders> getOrders() {
        return orders;
    }

    /**
     * Sets orders.
     *
     * @param orders the orders
     */
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", deviceIMEIOrSn='" + deviceIMEIOrSn + '\'' +
                ", devicePassword='" + devicePassword + '\'' +
                ", client=" + client +
                ", deviceCondition=" + deviceCondition +
                ", model=" + model +
                ", brand=" + brand +
                '}';
    }
}
