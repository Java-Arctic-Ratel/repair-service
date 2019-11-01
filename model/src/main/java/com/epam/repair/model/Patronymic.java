package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * The type Patronymic.
 */
@Entity
@Table(name = "patronymic")
public class Patronymic {

    /**
     * Patronymic id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="patronymic_generator")
    @SequenceGenerator(name="patronymic_generator",
            sequenceName="patronymic_generator", allocationSize=1000)
    @Column(name="patronymic_id", updatable=false, nullable=false)
    private Integer patronymicId;

    @Column(name="patronymic", length = 40, nullable=false)
    private String patronymic;

    @JsonIgnore
    @OneToMany(mappedBy="patronymic")
    private List<Client> clients;

    @JsonIgnore
    @OneToMany(mappedBy="patronymic")
    private List<Executor> executors;

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
     * Gets patronymic.
     *
     * @return the patronymic
     */
    public String getPatronymic() {
        return patronymic;
    }

    /**
     * Sets patronymic.
     *
     * @param patronymic the patronymic
     */
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
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
        return "Patronymic{" +
                "patronymicId=" + patronymicId +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }
}
