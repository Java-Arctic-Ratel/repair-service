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
@Table(name = "brand")
public class Brand {

    /**
     * Brand id is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "brand_generator")
    @SequenceGenerator(name = "brand_generator",
            sequenceName = "brand_seq", allocationSize = 1)
    @Column(name = "brand_id", updatable = false, nullable = false)
    private Integer brandId;

    @NotNull(message = "{brandName.null}")
    @NotBlank(message = "{brandName.empty}")
    @Size(max = 40, message = "{brandName.maxSize40}")
    @Column(name = "brand_name", length = 40, nullable = false)
    private String brandName;

    @JsonIgnore
    @OneToMany(mappedBy = "brand", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
    private List<Device> devices;

    /**
     * Gets brand id.
     *
     * @return the brand id
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * Sets brand id.
     *
     * @param brandId the brand id
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * Gets brand name.
     *
     * @return the brand name
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * Sets brand name.
     *
     * @param brandName the brand name
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
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
        return "Brand{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                '}';
    }
}
