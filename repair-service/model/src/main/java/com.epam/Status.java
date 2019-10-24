package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The type Status.
 */
@Entity
public class Status {

    /**
     * Status id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer statusId;

    private  String statusName;

    /**
     * Order id is the foreign key (status to order).
     */
    private Integer orderId;

    /**
     * Constructor without parameters.
     */
    public Status() {
    }

    /**
     * Constructor with parameters.
     *
     * @param statusName the status name
     * @param orderId    the order id
     */
    public Status(String statusName, Integer orderId) {
        this.statusName = statusName;
        this.orderId = orderId;
    }

    /**
     * Gets status id.
     *
     * @return the status id
     */
    public Integer getStatusId() {
        return statusId;
    }

    /**
     * Sets status id.
     *
     * @param statusId the status id
     */
    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    /**
     * Gets status name.
     *
     * @return the status name
     */
    public String getStatusName() {
        return statusName;
    }

    /**
     * Sets status name.
     *
     * @param statusName the status name
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    /**
     * Gets order id.
     *
     * @return the order id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * Sets order id.
     *
     * @param orderId the order id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
