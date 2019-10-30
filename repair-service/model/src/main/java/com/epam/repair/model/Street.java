package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="street_generator")
    @SequenceGenerator(name="street_generator",
            sequenceName="street_generator", allocationSize=1000)
    @Column(name="street_id", updatable=false, nullable=false)
    private Integer streetId;

    @Column(name="street_name", length = 40, nullable=false)
    private String streetName;

    @JsonIgnore
    @OneToMany(mappedBy="street", fetch = FetchType.EAGER)
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
                ", address=" + address +
                '}';
    }
}