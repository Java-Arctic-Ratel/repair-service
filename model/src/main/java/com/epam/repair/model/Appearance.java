package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * The type Appearance.
 */
@Entity
@Table(name = "appearance")
public class Appearance {

    /**
     * Appearance id is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "appearance_generator")
    @SequenceGenerator(name = "appearance_generator",
            sequenceName = "appearance_seq", allocationSize = 1)
    @Column(name = "appearance_id", updatable = false, nullable = false)
    private Integer appearanceId;

    @Column(name = "appearance_name", length = 40, nullable = false)
    private String appearanceName;

    @JsonIgnore
    @OneToMany(mappedBy = "appearance", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Device> devices;

    /**
     * Gets appearance id.
     *
     * @return the appearance id
     */
    public Integer getAppearanceId() {
        return appearanceId;
    }

    /**
     * Sets appearance id.
     *
     * @param appearanceId the appearance id
     */
    public void setAppearanceId(Integer appearanceId) {
        this.appearanceId = appearanceId;
    }

    /**
     * Gets appearance name.
     *
     * @return the appearance name
     */
    public String getAppearanceName() {
        return appearanceName;
    }

    /**
     * Sets appearance name.
     *
     * @param appearanceName the appearance name
     */
    public void setAppearanceName(String appearanceName) {
        this.appearanceName = appearanceName;
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
        return "Appearance{" +
                "appearanceId=" + appearanceId +
                ", appearanceName='" + appearanceName + '\'' +
                '}';
    }
}