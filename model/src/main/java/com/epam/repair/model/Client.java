package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Class represents entity with client information of repairing service.
 */
@Entity
@Table(name = "client")
public class Client {

    /**
     * Client id is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "client_generator")
    @SequenceGenerator(name = "client_generator",
            sequenceName = "client_seq", allocationSize = 1)
    @Column(name = "client_id", updatable = false, nullable = false)
    private Integer clientId;

    @Column(name = "client_phone_number", length = 40, nullable = false)
    private String clientPhoneNumber;

    @Column(name = "client_first_name", length = 40, nullable = false)
    private String firstName;

    @Column(name = "client_last_name", length = 40, nullable = false)
    private String lastName;

    /**
     * Address id is the foreign key (Address to client).
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "address_id")
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy = "client", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<RepairOrder> repairOrders;

    /**
     * Gets client id.
     *
     * @return the client id
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * Sets client id.
     *
     * @param clientId the client id
     */
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    /**
     * Gets client phone number.
     *
     * @return the client phone number
     */
    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    /**
     * Sets client phone number.
     *
     * @param clientPhoneNumber the client phone number
     */
    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets address.
     *
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * Sets address.
     *
     * @param address the address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * Gets repair orders.
     *
     * @return the repair orders
     */
    public List<RepairOrder> getRepairOrders() {
        return repairOrders;
    }

    /**
     * Sets repair orders.
     *
     * @param repairOrders the repair orders
     */
    public void setRepairOrders(List<RepairOrder> repairOrders) {
        this.repairOrders = repairOrders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientPhoneNumber='" + clientPhoneNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                '}';
    }
}
