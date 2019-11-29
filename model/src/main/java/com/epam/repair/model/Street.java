package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * The type Street.
 */
@Entity
@Table(name = "street")
public class Street {

    /**
     * Street id is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "street_generator")
    @SequenceGenerator(name = "street_generator",
            sequenceName = "street_seq", allocationSize = 1)
    @Column(name = "street_id", updatable = false, nullable = false)
    private Integer streetId;

    @NotNull(message = "{streetName.null}")
    @NotBlank(message = "{streetName.empty}")
    @Size(max = 40, message = "{streetName.maxSize40}")
    @Column(name = "street_name", length = 40, nullable = false)
    private String streetName;

    @JsonIgnore
    @OneToMany(mappedBy = "street", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Address> address;


    /**
     * Gets address.
     *
     * @return the address
     */
    public List<Address> getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(List<Address> address) {
        this.address = address;
    }

    /**
     * Gets street id.
     *
     * @return the street id
     */
    public Integer getStreetId() {
        return streetId;
    }

    /**
     * Sets street id.
     *
     * @param streetId the street id
     */
    public void setStreetId(Integer streetId) {
        this.streetId = streetId;
    }

    /**
     * Gets street name.
     *
     * @return the street name
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets street name.
     *
     * @param streetName the street name
     */
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    @Override
    public String toString() {
        return "Street{" +
                "streetId=" + streetId +
                ", streetName='" + streetName + '\'' +
                '}';
    }
}