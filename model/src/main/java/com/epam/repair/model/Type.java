package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * The type Brand.
 */
@Entity
@Table(name = "type")
public class Type {

    /**
     * Brand id is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "type_generator")
    @SequenceGenerator(name = "type_generator",
            sequenceName = "type_seq", allocationSize = 1)
    @Column(name = "type_id", updatable = false, nullable = false)
    private Integer typeId;

    @NotNull(message = "{typeName.null}")
    @NotBlank(message = "{typeName.empty}")
    @Size(max = 40, message = "{typeName.maxSize40}")
    @Column(name = "type_name", length = 40, nullable = false)
    private String typeName;

    @JsonIgnore
    @OneToMany(mappedBy = "type", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Device> devices;

    /**
     * Gets type id.
     *
     * @return the type id
     */
    public Integer getTypeId() {
        return typeId;
    }

    /**
     * Sets type id.
     *
     * @param typeId the type id
     */
    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * Gets type name.
     *
     * @return the type name
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Sets type name.
     *
     * @param typeName the type name
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
        return "Type{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}