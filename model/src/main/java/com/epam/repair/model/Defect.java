package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * The type Defect.
 */
@Entity
@Table(name = "defect")
public class Defect {

    /**
     * Defect id is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "defect_generator")
    @SequenceGenerator(name = "defect_generator",
            sequenceName = "defect_seq", allocationSize = 1)
    @Column(name = "defect_id", updatable = false, nullable = false)
    private Integer defectId;

    @NotNull(message = "{defectName.null}")
    @NotBlank(message = "{defectName.empty}")
    @Size(max = 40, message = "{defectName.maxSize40}")
    @Column(name = "defect_name", length = 40, nullable = false)
    private String defectName;

    @JsonIgnore
    @OneToMany(mappedBy = "defect", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Device> devices;

    /**
     * Gets defect id.
     *
     * @return the defect id
     */
    public Integer getDefectId() {
        return defectId;
    }

    /**
     * Sets defect id.
     *
     * @param defectId the defect id
     */
    public void setDefectId(Integer defectId) {
        this.defectId = defectId;
    }

    /**
     * Gets defect name.
     *
     * @return the defect name
     */
    public String getDefectName() {
        return defectName;
    }

    /**
     * Sets defect name.
     *
     * @param defectName the defect name
     */
    public void setDefectName(String defectName) {
        this.defectName = defectName;
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
        return "Defect{" +
                "defectId=" + defectId +
                ", defectName='" + defectName + '\'' +
                '}';
    }
}
