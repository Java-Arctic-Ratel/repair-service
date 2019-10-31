package com.epam.repair.model;

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

    @Override
    public String toString() {
        return "Model{" +
                "modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
