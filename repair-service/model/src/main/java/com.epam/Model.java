package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The type Model.
 */
@Entity
public class Model {

    /**
     * Model id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer modelId;

    private  String modelName;

    /**
     * Device id is the foreign key (Model to device).
     */
    private Integer deviceId;

    /**
     * Constructor without parameters.
     */
    public Model() {
    }

    /**
     * Constructor with parameters.
     *
     * @param modelName the model name
     * @param deviceId  the device id
     */
    public Model(String modelName, Integer deviceId) {
        this.modelName = modelName;
        this.deviceId = deviceId;
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
     * Gets model name.
     *
     * @return the model name
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Sets model name.
     *
     * @param modelName the model name
     */
    public void setModelName(String modelName) {
        this.modelName = modelName;
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

    @Override
    public String toString() {
        return "Model{" +
                "modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                ", deviceId=" + deviceId +
                '}';
    }
}
