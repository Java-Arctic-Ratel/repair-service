package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * The type Executor.
 */
@Entity
@Table(name = "executor")
public class Executor {

    /**
     * Device condition id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="executor_generator")
    @SequenceGenerator(name="executor_generator",
            sequenceName="executor_generator", allocationSize=1000)
    @Column(name="executor_id", updatable=false, nullable=false)
    private Integer executorId;

    /**
     * First name id is the foreign key (First name to executor).
     */
    @ManyToOne
    @JoinColumn(name="first_name_id")
    private FirstName firstName;

    /**
     * Last name id is the foreign key (Last name to executor).
     */
    @ManyToOne
    @JoinColumn (name="last_name_id")
    private LastName lastName;

    /**
     * Patronymic id is the foreign key (Patronymic to executor).
     */
    @ManyToOne
    @JoinColumn (name="patronymic_id")
    private Patronymic patronymic;

    @JsonIgnore
    @OneToMany(mappedBy="executor")
    private List<Orders> orders;

    /**
     * Gets executor id.
     *
     * @return the executor id
     */
    public Integer getExecutorId() {
        return executorId;
    }

    /**
     * Sets executor id.
     *
     * @param executorId the executor id
     */
    public void setExecutorId(Integer executorId) {
        this.executorId = executorId;
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
        return "Executor{" +
                "executorId=" + executorId +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", patronymic=" + patronymic +
                '}';
    }
}
