package com.epam.repair.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type Orders.
 */
@Entity
@Table(name = "orders")
public class Orders {

    /**
     * Orders id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="orders_generator")
    @SequenceGenerator(name="orders_generator",
            sequenceName="orders_generator", allocationSize=1000)
    @Column(name="orders_id", updatable=false, nullable=false)
    private Integer ordersId;

    @Column(name="orders_start_date", nullable=false)
    private LocalDate ordersStartDate;

    @Column(name="orders_end_date", nullable=false)
    private LocalDate ordersEndDate;

    @Column(name="orders_issue_date", nullable=false)
    private LocalDate ordersIssueDate;

    @Column(name="orders_cost_estimated", nullable=false)
    private BigDecimal ordersCostEstimated;

    @Column(name="orders_cost_total", nullable=false)
    private BigDecimal ordersCostTotal;

    /**
     * Client id is the foreign key (Client to orders).
     */
    @ManyToOne
    @JoinColumn (name="client_id")
    private Client client;

    /**
     * Device id is the foreign key (Device to orders).
     */
    @ManyToOne
    @JoinColumn (name="device_id")
    private Device device;

    /**
     * Executor id is the foreign key (Executor to orders).
     */
    @ManyToOne
    @JoinColumn (name="executor_id")
    private Executor executor;

    /**
     * Spare parts id is the foreign key (Spare parts to orders).
     */
    @ManyToOne
    @JoinColumn (name="spareParts_id")
    private SpareParts spareParts;

    /**
     * Status id is the foreign key (Status to orders).
     */
    @ManyToOne
    @JoinColumn (name="status_id")
    private Status status;

    /**
     * Gets orders id.
     *
     * @return the orders id
     */
    public Integer getOrdersId() {
        return ordersId;
    }

    /**
     * Sets orders id.
     *
     * @param ordersId the orders id
     */
    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    /**
     * Gets orders start date.
     *
     * @return the orders start date
     */
    public LocalDate getOrdersStartDate() {
        return ordersStartDate;
    }

    /**
     * Sets orders start date.
     *
     * @param ordersStartDate the orders start date
     */
    public void setOrdersStartDate(LocalDate ordersStartDate) {
        this.ordersStartDate = ordersStartDate;
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
     * Gets client.
     *
     * @return the client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Sets client.
     *
     * @param client the client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Gets device.
     *
     * @return the device
     */
    public Device getDevice() {
        return device;
    }

    /**
     * Sets device.
     *
     * @param device the device
     */
    public void setDevice(Device device) {
        this.device = device;
    }

    /**
     * Gets executor.
     *
     * @return the executor
     */
    public Executor getExecutor() {
        return executor;
    }

    /**
     * Sets executor.
     *
     * @param executor the executor
     */
    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    /**
     * Gets spare parts.
     *
     * @return the spare parts
     */
    public SpareParts getSpareParts() {
        return spareParts;
    }

    /**
     * Sets spare parts.
     *
     * @param spareParts the spare parts
     */
    public void setSpareParts(SpareParts spareParts) {
        this.spareParts = spareParts;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "ordersId=" + ordersId +
                ", ordersStartDate=" + ordersStartDate +
                ", ordersEndDate=" + ordersEndDate +
                ", ordersIssueDate=" + ordersIssueDate +
                ", ordersCostEstimated=" + ordersCostEstimated +
                ", ordersCostTotal=" + ordersCostTotal +
                ", client=" + client +
                ", device=" + device +
                ", executor=" + executor +
                ", spareParts=" + spareParts +
                ", status=" + status +
                '}';
    }
}

