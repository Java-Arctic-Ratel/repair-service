package com.epam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;

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
     * @param dateStart Date of start registration..
     * @param dateEnd        Date of ent registration.
     * @param dateIssue    Date of issue.
     * @param costEstimated Cost estimated.
     * @param sparePartsId    Spare parts id.
     * @param costTotal    Cost total.
     * @param clientId    Client id.
     * @param executorId    Executor id.
     * @param statusId    Status id.
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


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDate getDateStart() {
        return dateStart;
    }

    public void setDateStart(LocalDate dateStart) {
        this.dateStart = dateStart;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public LocalDate getDateIssue() {
        return dateIssue;
    }

    public void setDateIssue(LocalDate dateIssue) {
        this.dateIssue = dateIssue;
    }

    public BigDecimal getCostEstimated() {
        return costEstimated;
    }

    public void setCostEstimated(BigDecimal costEstimated) {
        this.costEstimated = costEstimated;
    }

    public Integer getSparePartsId() {
        return sparePartsId;
    }

    public void setSparePartsId(Integer sparePartsId) {
        this.sparePartsId = sparePartsId;
    }

    public BigDecimal getCostTotal() {
        return costTotal;
    }

    public void setCostTotal(BigDecimal costTotal) {
        this.costTotal = costTotal;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getExecutorId() {
        return executorId;
    }

    public void setExecutorId(Integer executorId) {
        this.executorId = executorId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}

