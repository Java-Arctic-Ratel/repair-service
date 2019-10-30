package com.epam.repair.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The type Executor.
 */
@Entity
public class Executor {

    /**
     * Device condition id is the primary key.
     */
    @Id
    @GeneratedValue
    private Integer executorId;
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

    @Override
    public String toString() {
        return "Executor{" +
                "executorId=" + executorId +
                ", firstNameId=" + firstNameId +
                ", lastNameId=" + lastNameId +
                ", patronymicId=" + patronymicId +
                '}';
    }
}
