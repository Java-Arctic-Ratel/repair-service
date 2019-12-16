package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * The type Model.
 */
@Entity
@Table(name = "model")
public class Model {

    /**
     * Model id is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "model_generator")
    @SequenceGenerator(name = "model_generator",
            sequenceName = "model_seq", allocationSize = 1)
    @Column(name = "model_id", updatable = false, nullable = false)
    private Integer modelId;

    @NotNull(message = "{modelName.null}")
    @NotBlank(message = "{modelName.empty}")
    @Size(max = 40, message = "{modelName.maxSize40}")
    @Column(name = "model_name", length = 40, nullable = false)
    private String modelName;

    @JsonIgnore
    @OneToMany(mappedBy = "model", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Device> devices;

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
     * Gets devices.
     *
     * @return the devices
     */
    public List<Device> getDevices() {
        return devices;
    }

    /**
     * Sets devices.
     *
     * @param devices the devices
     */
    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public String toString() {
        return "Model{" +
                "modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
