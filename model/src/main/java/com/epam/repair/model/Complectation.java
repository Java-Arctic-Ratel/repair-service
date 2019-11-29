package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * The type Complectation.
 */
@Entity
@Table(name = "complectation")
public class Complectation {

    /**
     * Complectation id is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "complectation_generator")
    @SequenceGenerator(name = "complectation_generator",
            sequenceName = "complectation_seq", allocationSize = 1)
    @Column(name = "complectation_id", updatable = false, nullable = false)
    private Integer complectationId;

    @NotNull(message = "{complectationName.null}")
    @NotBlank(message = "{complectationName.empty}")
    @Size(max = 40, message = "{complectationName.maxSize40}")
    @Column(name = "complectation_name", length = 40, nullable = false)
    private String complectationName;

    @JsonIgnore
    @OneToMany(mappedBy = "complectation", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Device> devices;

    /**
     * Gets complectation id.
     *
     * @return the complectation id
     */
    public Integer getComplectationId() {
        return complectationId;
    }

    /**
     * Sets complectation id.
     *
     * @param complectationId the complectation id
     */
    public void setComplectationId(Integer complectationId) {
        this.complectationId = complectationId;
    }

    /**
     * Gets complectation name.
     *
     * @return the complectation name
     */
    public String getComplectationName() {
        return complectationName;
    }

    /**
     * Sets complectation name.
     *
     * @param complectationName the complectation name
     */
    public void setComplectationName(String complectationName) {
        this.complectationName = complectationName;
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
        return "Complectation{" +
                "complectationId=" + complectationId +
                ", complectationName='" + complectationName + '\'' +
                '}';
    }
}
