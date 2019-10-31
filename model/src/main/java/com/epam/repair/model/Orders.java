package com.epam.repair.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Order.
 */
@Entity
public class Orders {

    /**
     * Orders id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer ordersId;
    private LocalDate ordersStatDate;
    private LocalDate ordersEndDate;
    private LocalDate ordersIssueDate;
    private BigDecimal ordersCostEstimated;
    /**
     * Spare parts id is the foreign key (Spare parts to orders).
     */
    private Integer sparePartsId;
    private BigDecimal ordersCostTotal;
    /**
     * Client id is the foreign key (Client to orders).
     */
    private Integer clientId;
    /**
     * Device id is the foreign key (Device to orders).
     */
    private Integer deviceId;
    /**
     * Executor id is the foreign key (Executor to orders).
     */
    private Integer executorId;
    /**
     * Status id is the foreign key (Status to orders).
     */
    private Integer statusId;

    /**
     * Gets orders stat date.
     *
     * @return the orders stat date
     */
    public LocalDate getOrdersStatDate() {
        return ordersStatDate;
    }

    /**
     * Sets orders stat date.
     *
     * @param ordersStatDate the orders stat date
     */
    public void setOrdersStatDate(LocalDate ordersStatDate) {
        this.ordersStatDate = ordersStatDate;
    }

    /**
     * Gets orders end date.
     *
     * @return the orders end date
     */
    public LocalDate getOrdersEndDate() {
        return ordersEndDate;
    }

    /**
     * Sets orders end date.
     *
     * @param ordersEndDate the orders end date
     */
    public void setOrdersEndDate(LocalDate ordersEndDate) {
        this.ordersEndDate = ordersEndDate;
    }

    /**
     * Gets orders issue date.
     *
     * @return the orders issue date
     */
    public LocalDate getOrdersIssueDate() {
        return ordersIssueDate;
    }

    /**
     * Sets orders issue date.
     *
     * @param ordersIssueDate the orders issue date
     */
    public void setOrdersIssueDate(LocalDate ordersIssueDate) {
        this.ordersIssueDate = ordersIssueDate;
    }

    /**
     * Gets orders cost estimated.
     *
     * @return the orders cost estimated
     */
    public BigDecimal getOrdersCostEstimated() {
        return ordersCostEstimated;
    }

    /**
     * Sets orders cost estimated.
     *
     * @param ordersCostEstimated the orders cost estimated
     */
    public void setOrdersCostEstimated(BigDecimal ordersCostEstimated) {
        this.ordersCostEstimated = ordersCostEstimated;
    }

    /**
     * Gets spare parts id.
     *
     * @return the spare parts id
     */
    public Integer getSparePartsId() {
        return sparePartsId;
    }

    /**
     * Sets spare parts id.
     *
     * @param sparePartsId the spare parts id
     */
    public void setSparePartsId(Integer sparePartsId) {
        this.sparePartsId = sparePartsId;
    }

    /**
     * Gets orders cost total.
     *
     * @return the orders cost total
     */
    public BigDecimal getOrdersCostTotal() {
        return ordersCostTotal;
    }

    /**
     * Sets orders cost total.
     *
     * @param ordersCostTotal the orders cost total
     */
    public void setOrdersCostTotal(BigDecimal ordersCostTotal) {
        this.ordersCostTotal = ordersCostTotal;
    }

    /**
     * Gets client id.
     *
     * @return the client id
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
     * Gets device id.
     *
     * @return the device id
     */
    public Integer getDeviceId() {
        return deviceId;
    }

    /**
     * Sets device id.
     *
     * @param deviceId the device id
     */
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

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

    @Override
    public String toString() {
        return "Orders{" +
                "ordersId=" + ordersId +
                ", ordersStatDate=" + ordersStatDate +
                ", ordersEndDate=" + ordersEndDate +
                ", ordersIssueDate=" + ordersIssueDate +
                ", ordersCostEstimated=" + ordersCostEstimated +
                ", sparePartsId=" + sparePartsId +
                ", ordersCostTotal=" + ordersCostTotal +
                ", clientId=" + clientId +
                ", deviceId=" + deviceId +
                ", executorId=" + executorId +
                ", statusId=" + statusId +
                '}';
    }
}

