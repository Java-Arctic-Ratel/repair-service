package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "device_generator")
    @SequenceGenerator(name = "device_generator",
            sequenceName = "device_seq", allocationSize = 1)
    @Column(name = "device_id", updatable = false, nullable = false)
    private Integer deviceId;

    @NotNull(message = "{devicePassword.null}")
    @NotBlank(message = "{devicePassword.empty}")
    @Size(max = 40, message = "{deviceIMEIOrSn.maxSize40}")
    @Column(name = "device_imei_or_sn", length = 40, nullable = false)
    private String deviceIMEIOrSn;

    @NotNull(message = "{devicePassword.null}")
    @NotBlank(message = "{devicePassword.empty}")
    @Size(max = 40, message = "{devicePassword.maxSize40}")
    @Column(name = "device_password", length = 40, nullable = false)
    private String devicePassword;

    /**
     * Type id is the foreign key (Type to device).
     */
    @Valid
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "type_id")
    private Type type;

    /**
     * Model id is the foreign key (Model to device).
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "model_id")
    private Model model;

    /**
     * Brand id is the foreign key (Brand to device).
     */
    @Valid
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "brand_id")
    private Brand brand;

    /**
     * Appearance id is the foreign key (Appearance to device).
     */
    @Valid
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "appearance_id")
    private Appearance appearance;

    /**
     * Complectation id is the foreign key (Complectation to device).
     */
    @Valid
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "complectation_id")
    private Complectation complectation;

    /**
     * Defect id is the foreign key (Defect to device).
     */
    @Valid
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "defect_id")
    private Defect defect;

    @JsonIgnore
    @OneToMany(mappedBy = "device", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<RepairOrder> repairOrders;

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
     * Gets type.
     *
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(Type type) {
        this.type = type;
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
     * Gets repair orders.
     *
     * @return the repair orders
     */
    public List<RepairOrder> getRepairOrders() {
        return repairOrders;
    }

    /**
     * Sets repair orders.
     *
     * @param repairOrders the repair orders
     */
    public void setRepairOrders(List<RepairOrder> repairOrders) {
        this.repairOrders = repairOrders;
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + deviceId +
                ", deviceIMEIOrSn='" + deviceIMEIOrSn + '\'' +
                ", devicePassword='" + devicePassword + '\'' +
                ", type=" + type +
                ", model=" + model +
                ", brand=" + brand +
                ", appearance=" + appearance +
                ", complectation=" + complectation +
                ", defect=" + defect +
                '}';
    }
}
