package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
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
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="client_generator")
    @SequenceGenerator(name="client_generator",
            sequenceName="client_generator", allocationSize=1000)
    @Column(name="client_id", updatable=false, nullable=false)
    private Integer clientId;

    @Column(name="client_phone_number", length = 40, nullable=false)
    private String clientPhoneNumber;

    /**
     * First name id is the foreign key (First name to client).
     */
    @ManyToOne
    @JoinColumn (name="first_name_id")
    private FirstName firstName;

    /**
     * Last name id is the foreign key (Last name to client).
     */
    @ManyToOne
    @JoinColumn (name="last_name_id")
    private LastName lastName;

    /**
     * Patronymic id is the foreign key (Patronymic to client).
     */
    @ManyToOne
    @JoinColumn (name="patronymic_id")
    private Patronymic patronymic;

    /**
     * Address id is the foreign key (Address to client).
     */
    @ManyToOne
    @JoinColumn (name="address_id")
    private Address address;

    @JsonIgnore
    @OneToMany(mappedBy="client")
    private List<Device> devices;

    @JsonIgnore
    @OneToMany(mappedBy="client")
    private List<Orders> orders;

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
    public FirstName getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(FirstName firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public LastName getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(LastName lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets patronymic.
     *
     * @return the patronymic
     */
    public Patronymic getPatronymic() {
        return patronymic;
    }

    /**
     * Sets patronymic.
     *
     * @param patronymic the patronymic
     */
    public void setPatronymic(Patronymic patronymic) {
        this.patronymic = patronymic;
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

    /**
     * Gets orders.
     *
     * @return the orders
     */
    public List<Orders> getOrders() {
        return orders;
    }

    /**
     * Sets orders.
     *
     * @param orders the orders
     */
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientPhoneNumber='" + clientPhoneNumber + '\'' +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", patronymic=" + patronymic +
                ", address=" + address +
                '}';
    }
}
