package com.epam.repair.model.dto;

/**
 * The type Client dto.
 */
public class ClientDTO {

    private String clientPhoneNumber;
    private String firstName;
    private String lastName;

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
}
