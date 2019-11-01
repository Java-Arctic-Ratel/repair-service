package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * The type Last name.
 */
@Entity
@Table(name = "last_name")
public class LastName {

    /**
     * Device condition id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="last_name_generator")
    @SequenceGenerator(name="last_name_generator",
            sequenceName="last_name_generator", allocationSize=1000)
    @Column(name="last_name_id", updatable=false, nullable=false)
    private Integer lastNameId;

    @Column(name="last_name", length = 40, nullable=false)
    private String lastName;

    @JsonIgnore
    @OneToMany(mappedBy="lastName")
    private List<Client> clients;

    @JsonIgnore
    @OneToMany(mappedBy="lastName")
    private List<Executor> executors;

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
        return "LastName{" +
                "lastNameId=" + lastNameId +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
