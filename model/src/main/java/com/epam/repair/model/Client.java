package com.epam.repair.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class represents entity with client information of repairing service.
 */
@Entity
public class Client {

    /**
     * City id is the primary key.
     */
    @Id
    @GeneratedValue
    private Integer clientId;
    private String clientPhoneNumber;
    /**
     * First name id is the foreign key (First name to client).
     */
    private Integer firstNameId;
    /**
     * Last name id is the foreign key (Last name to client).
     */
    private Integer lastNameId;
    /**
     * Patronymic id is the foreign key (Patronymic to client).
     */
    private Integer patronymicId;
    /**
     * Address id is the foreign key (Address name to client).
     */
    private Integer AddressId;

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
     * Gets first name id.
     *
     * @return the first name id
     */
    public Integer getFirstNameId() {
        return firstNameId;
    }

    /**
     * Sets first name id.
     *
     * @param firstNameId the first name id
     */
    public void setFirstNameId(Integer firstNameId) {
        this.firstNameId = firstNameId;
    }

    /**
     * Gets last name id.
     *
     * @return the last name id
     */
    public Integer getLastNameId() {
        return lastNameId;
    }

    /**
     * Sets last name id.
     *
     * @param lastNameId the last name id
     */
    public void setLastNameId(Integer lastNameId) {
        this.lastNameId = lastNameId;
    }

    /**
     * Gets patronymic id.
     *
     * @return the patronymic id
     */
    public Integer getPatronymicId() {
        return patronymicId;
    }

    /**
     * Sets patronymic id.
     *
     * @param patronymicId the patronymic id
     */
    public void setPatronymicId(Integer patronymicId) {
        this.patronymicId = patronymicId;
    }

    /**
     * Gets address id.
     *
     * @return the address id
     */
    public Integer getAddressId() {
        return AddressId;
    }

    /**
     * Sets address id.
     *
     * @param addressId the address id
     */
    public void setAddressId(Integer addressId) {
        AddressId = addressId;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientPhoneNumber='" + clientPhoneNumber + '\'' +
                ", firstNameId=" + firstNameId +
                ", lastNameId=" + lastNameId +
                ", patronymicId=" + patronymicId +
                ", AddressId=" + AddressId +
                '}';
    }
}
