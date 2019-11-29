package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * The type Address.
 */
@Entity
@Table(name = "address")
public class Address {

    /**
     * Address id is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "address_generator")
    @SequenceGenerator(name = "address_generator",
            sequenceName = "address_seq", allocationSize = 1)
    @Column(name = "address_id", updatable = false, nullable = false)
    private Integer addressId;

    @NotNull(message = "{houseNumber.null}")
    @NotBlank(message = "{houseNumber.empty}")
    @Size(max = 40, message = "{houseNumber.maxSize40}")
    @Column(name = "address_number_house", length = 40, nullable = false)
    private String houseNumber;

    @NotNull(message = "{apartmentNumber.null}")
    @NotBlank(message = "{apartmentNumber.empty}")
    @Size(max = 40, message = "{apartmentNumber.maxSize40}")
    @Column(name = "address_number_apartment", length = 40, nullable = false)
    private String apartmentNumber;

    /**
     * City id is the foreign key (City to address).
     */
    @Valid
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "city_id")
    private City city;

    /**
     * Street id is the foreign key (Street to address).
     */
    @Valid
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "street_id")
    private Street street;

    @JsonIgnore
    @OneToMany(mappedBy = "address")
    private List<Client> clients;

    /**
     * Gets address id.
     *
     * @return the address id
     */
    public Integer getAddressId() {
        return addressId;
    }

    /**
     * Sets address id.
     *
     * @param addressId the address id
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    /**
     * Gets house number.
     *
     * @return the house number
     */
    public String getHouseNumber() {
        return houseNumber;
    }

    /**
     * Sets house number.
     *
     * @param houseNumber the house number
     */
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * Gets apartment number.
     *
     * @return the apartment number
     */
    public String getApartmentNumber() {
        return apartmentNumber;
    }

    /**
     * Sets apartment number.
     *
     * @param apartmentNumber the apartment number
     */
    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public City getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(City city) {
        this.city = city;
    }

    /**
     * Gets street.
     *
     * @return the street
     */
    public Street getStreet() {
        return street;
    }

    /**
     * Sets street.
     *
     * @param street the street
     */
    public void setStreet(Street street) {
        this.street = street;
    }

    /**
     * Gets clients.
     *
     * @return the clients
     */
    public List<Client> getClients() {
        return clients;
    }

    /**
     * Sets clients.
     *
     * @param clients the clients
     */
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", houseNumber='" + houseNumber + '\'' +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                ", city=" + city +
                ", street=" + street +
                '}';
    }
}