package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The type Executor.
 */
@Entity
public class Executor {

    @Id
    @GeneratedValue
    private Integer executorId;

    private Integer executorOrderId;

    private Integer firstNameId;

    private Integer lastNameId;

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
     * Gets executor order id.
     *
     * @return the executor order id
     */
    public Integer getExecutorOrderId() {
        return executorOrderId;
    }

    /**
     * Sets executor order id.
     *
     * @param executorOrderId the executor order id
     */
    public void setExecutorOrderId(Integer executorOrderId) {
        this.executorOrderId = executorOrderId;
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
                ", executorOrderId=" + executorOrderId +
                ", firstNameId=" + firstNameId +
                ", lastNameId=" + lastNameId +
                ", patronymicId=" + patronymicId +
                '}';
    }
}
