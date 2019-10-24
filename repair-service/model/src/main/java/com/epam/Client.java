package com.epam;

public class Client {

    private Integer clientId;

    private String clientPhoneNumber;

    private Integer clientAddressId;

    private Integer firstNameId;

    private Integer lastNameId;

    private Integer patronymicId;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getClientPhoneNumber() {
        return clientPhoneNumber;
    }

    public void setClientPhoneNumber(String clientPhoneNumber) {
        this.clientPhoneNumber = clientPhoneNumber;
    }

    public Integer getClientAddressId() {
        return clientAddressId;
    }

    public void setClientAddressId(Integer clientAddressId) {
        this.clientAddressId = clientAddressId;
    }

    public Integer getFirstNameId() {
        return firstNameId;
    }

    public void setFirstNameId(Integer firstNameId) {
        this.firstNameId = firstNameId;
    }

    public Integer getLastNameId() {
        return lastNameId;
    }

    public void setLastNameId(Integer lastNameId) {
        this.lastNameId = lastNameId;
    }

    public Integer getPatronymicId() {
        return patronymicId;
    }

    public void setPatronymicId(Integer patronymicId) {
        this.patronymicId = patronymicId;
    }

    public Client() {
    }

    public Client(String clientPhoneNumber, Integer clientAddressId, Integer firstNameId, Integer lastNameId, Integer patronymicId) {
        this.clientPhoneNumber = clientPhoneNumber;
        this.clientAddressId = clientAddressId;
        this.firstNameId = firstNameId;
        this.lastNameId = lastNameId;
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
