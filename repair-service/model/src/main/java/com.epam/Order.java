package com.epam;

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
public class Order {

    /**
     * Order id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer orderId;

    private LocalDate dateStart;
    private LocalDate dateEnd;
    private LocalDate dateIssue;
    private BigDecimal costEstimated;

    /**
     * Spare parts id is the foreign key (order to spare parts).
     */
    private Integer sparePartsId;

    private BigDecimal costTotal;

    /**
     * Client id is the foreign key (order to client).
     */
    private Integer clientId;

    /**
     * Executor id is the foreign key (order to executor).
     */
    private Integer executorId;

    /**
     * Status id is the foreign key (order to status).
     */
    private Integer statusId;


    /**
     * Constructor without parameters.
     */
    public Order() {
    }

    /**
     * Constructor with parameters.
     *
     * @param dateStart     Date of start registration..
     * @param dateEnd       Date of ent registration.
     * @param dateIssue     Date of issue.
     * @param costEstimated Cost estimated.
     * @param sparePartsId  Spare parts id.
     * @param costTotal     Cost total.
     * @param clientId      Client id.
     * @param executorId    Executor id.
     * @param statusId      Status id.
     */
    public Order(LocalDate dateStart, LocalDate dateEnd, LocalDate dateIssue, BigDecimal costEstimated, Integer sparePartsId,
                 BigDecimal costTotal, Integer clientId, Integer executorId, Integer statusId) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.dateIssue = dateIssue;
        this.costEstimated = costEstimated;
        this.sparePartsId = sparePartsId;
        this.costTotal = costTotal;
        this.clientId = clientId;
        this.executorId = executorId;
        this.statusId = statusId;
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

    /**
     * Gets date start.
     *
     * @return the date start
     */
    public LocalDate getDateStart() {
        return dateStart;
    }

    /**
     * Sets date start.
     *
     * @param dateStart the date start
     */
    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    /**
     * Gets date end.
     *
     * @return the date end
     */
    public LocalDate getDateEnd() {
        return dateEnd;
    }

    /**
     * Sets date end.
     *
     * @param dateEnd the date end
     */
    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    /**
     * Gets date issue.
     *
     * @return the date issue
     */
    public LocalDate getDateIssue() {
        return dateIssue;
    }

    /**
     * Sets date issue.
     *
     * @param dateIssue the date issue
     */
    public void setDateIssue(LocalDate dateIssue) {
        this.dateIssue = dateIssue;
    }

    /**
     * Gets cost estimated.
     *
     * @return the cost estimated
     */
    public BigDecimal getCostEstimated() {
        return costEstimated;
    }

    /**
     * Sets cost estimated.
     *
     * @param costEstimated the cost estimated
     */
    public void setCostEstimated(BigDecimal costEstimated) {
        this.costEstimated = costEstimated;
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
     * Gets cost total.
     *
     * @return the cost total
     */
    public BigDecimal getCostTotal() {
        return costTotal;
    }

    /**
     * Sets cost total.
     *
     * @param costTotal the cost total
     */
    public void setCostTotal(BigDecimal costTotal) {
        this.costTotal = costTotal;
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
}

