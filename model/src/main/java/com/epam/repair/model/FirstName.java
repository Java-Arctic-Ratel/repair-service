package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * The type First name.
 */
@Entity
@Table(name = "first_name")
public class FirstName {

    /**
     * Device condition id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="first_name_generator")
    @SequenceGenerator(name="first_name_generator",
            sequenceName="first_name_generator", allocationSize=1000)
    @Column(name="first_name_id", updatable=false, nullable=false)
    private Integer firstNameId;

    @Column(name="first_name", length = 40, nullable=false)
    private String firstName;

    @JsonIgnore
    @OneToMany(mappedBy="firstName")
    private List<Client> clients;

    @JsonIgnore
    @OneToMany(mappedBy="firstName")
    private List<Executor> executors;

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

    /**
     * Gets executors.
     *
     * @return the executors
     */
    public List<Executor> getExecutors() {
        return executors;
    }

    /**
     * Sets executors.
     *
     * @param executors the executors
     */
    public void setExecutors(List<Executor> executors) {
        this.executors = executors;
    }

    @Override
    public String toString() {
        return "FirstName{" +
                "firstNameId=" + firstNameId +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
