package com.epam.repair.model.dto;

/**
 * The type Device dto.
 */
public class DeviceDTO {

    private String deviceIMEIOrSn;
    private String devicePassword;
    private TypeDTO type;
    private ModelDTO model;
    private BrandDTO brand;
    private AppearanceDTO appearance;
    private ComplectationDTO complectation;
    private DefectDTO defect;

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
    public TypeDTO getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(TypeDTO type) {
        this.type = type;
    }

    /**
     * Gets model.
     *
     * @return the model
     */
    public ModelDTO getModel() {
        return model;
    }

    /**
     * Sets model.
     *
     * @param model the model
     */
    public void setModel(ModelDTO model) {
        this.model = model;
    }

    /**
     * Gets brand.
     *
     * @return the brand
     */
    public BrandDTO getBrand() {
        return brand;
    }

    /**
     * Sets brand.
     *
     * @param brand the brand
     */
    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }

    /**
     * Gets appearance.
     *
     * @return the appearance
     */
    public AppearanceDTO getAppearance() {
        return appearance;
    }

    /**
     * Sets appearance.
     *
     * @param appearance the appearance
     */
    public void setAppearance(AppearanceDTO appearance) {
        this.appearance = appearance;
    }

    /**
     * Gets complectation.
     *
     * @return the complectation
     */
    public ComplectationDTO getComplectation() {
        return complectation;
    }

    /**
     * Sets complectation.
     *
     * @param complectation the complectation
     */
    public void setComplectation(ComplectationDTO complectation) {
        this.complectation = complectation;
    }

    /**
     * Gets defect.
     *
     * @return the defect
     */
    public DefectDTO getDefect() {
        return defect;
    }

    /**
     * Sets defect.
     *
     * @param defect the defect
     */
    public void setDefect(DefectDTO defect) {
        this.defect = defect;
    }
}
