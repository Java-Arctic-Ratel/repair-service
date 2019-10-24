package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Class represents entity with client information of repairing service.
 */
@Entity
public class Client {

    @Id
    @GeneratedValue
    private Integer clientId;

    private String clientPhoneNumber;

    private Integer clientAddressId;

    private Integer firstNameId;

    private Integer lastNameId;

    private Integer patronymicId;

    /**
     * Gets client id.
     *
     * @return client id
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
     * @return client phone number
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
     * Gets client address id.
     *
     * @return client address id
     */
    public Integer getClientAddressId() {
        return clientAddressId;
    }

    /**
     * Sets client address id.
     *
     * @param clientAddressId the client address id
     */
    public void setClientAddressId(Integer clientAddressId) {
        this.clientAddressId = clientAddressId;
    }

    /**
     * Gets first name id.
     *
     * @return first name id
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
     * @return last name id
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
     * @return patronymic id
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

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientPhoneNumber='" + clientPhoneNumber + '\'' +
                ", clientAddressId=" + clientAddressId +
                ", firstNameId=" + firstNameId +
                ", lastNameId=" + lastNameId +
                ", patronymicId=" + patronymicId +
                '}';
    }
}
