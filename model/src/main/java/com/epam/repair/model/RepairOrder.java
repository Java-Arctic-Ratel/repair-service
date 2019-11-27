package com.epam.repair.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type order.
 */
@Entity
@Table(name = "repair_order")
public class RepairOrder {

    /**
     * Order id is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "repair_order_generator")
    @SequenceGenerator(name = "repair_order_generator",
            sequenceName = "repair_order_seq", allocationSize = 1)
    @Column(name = "repair_order_id", updatable = false, nullable = false)
    private Integer repairOrderId;

    @Column(name = "repair_order_start_date", nullable = true)
    private LocalDate repairOrderStartDate;

    @Column(name = "repair_order_end_date", nullable = true)
    private LocalDate repairOrderEndDate;

    @Column(name = "repair_order_issue_date", nullable = true)
    private LocalDate repairOrderIssueDate;

    @Column(name = "repair_order_cost_estimated", nullable = false)
    private BigDecimal repairOrderCostEstimated;

    @Column(name = "repair_order_cost_total", nullable = false)
    private BigDecimal repairOrderCostTotal;

    /**
     * Client id is the foreign key (Client to order).
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "client_id")
    private Client client;

    /**
     * Device id is the foreign key (Device to order).
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "device_id")
    private Device device;

    /**
     * Employee id is the foreign key (Executor to order).
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "employee_id")
    private Employee employee;

    /**
     * Spare parts id is the foreign key (Spare parts to order).
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "spare_part_id")
    private SparePart sparePart;

    /**
     * Status id is the foreign key (Status to order).
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "status_id")
    private Status status;

    /**
     * Gets repair order id.
     *
     * @return the repair order id
     */
    public Integer getRepairOrderId() {
        return repairOrderId;
    }

    /**
     * Sets repair order id.
     *
     * @param repairOrderId the repair order id
     */
    public void setRepairOrderId(Integer repairOrderId) {
        this.repairOrderId = repairOrderId;
    }

    /**
     * Gets repair order start date.
     *
     * @return the repair order start date
     */
    public LocalDate getRepairOrderStartDate() {
        return repairOrderStartDate;
    }

    /**
     * Sets repair order start date.
     *
     * @param repairOrderStartDate the repair order start date
     */
    public void setRepairOrderStartDate(LocalDate repairOrderStartDate) {
        this.repairOrderStartDate = repairOrderStartDate;
    }

    /**
     * Gets repair order end date.
     *
     * @return the repair order end date
     */
    public LocalDate getRepairOrderEndDate() {
        return repairOrderEndDate;
    }

    /**
     * Sets repair order end date.
     *
     * @param repairOrderEndDate the repair order end date
     */
    public void setRepairOrderEndDate(LocalDate repairOrderEndDate) {
        this.repairOrderEndDate = repairOrderEndDate;
    }

    /**
     * Gets repair order issue date.
     *
     * @return the repair order issue date
     */
    public LocalDate getRepairOrderIssueDate() {
        return repairOrderIssueDate;
    }

    /**
     * Sets repair order issue date.
     *
     * @param repairOrderIssueDate the repair order issue date
     */
    public void setRepairOrderIssueDate(LocalDate repairOrderIssueDate) {
        this.repairOrderIssueDate = repairOrderIssueDate;
    }

    /**
     * Gets repair order cost estimated.
     *
     * @return the repair order cost estimated
     */
    public BigDecimal getRepairOrderCostEstimated() {
        return repairOrderCostEstimated;
    }

    /**
     * Sets repair order cost estimated.
     *
     * @param repairOrderCostEstimated the repair order cost estimated
     */
    public void setRepairOrderCostEstimated(BigDecimal repairOrderCostEstimated) {
        this.repairOrderCostEstimated = repairOrderCostEstimated;
    }

    /**
     * Gets repair order cost total.
     *
     * @return the repair order cost total
     */
    public BigDecimal getRepairOrderCostTotal() {
        return repairOrderCostTotal;
    }

    /**
     * Sets repair order cost total.
     *
     * @param repairOrderCostTotal the repair order cost total
     */
    public void setRepairOrderCostTotal(BigDecimal repairOrderCostTotal) {
        this.repairOrderCostTotal = repairOrderCostTotal;
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
     * Gets employee.
     *
     * @return the employee
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * Sets employee.
     *
     * @param employee the employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    /**
     * Gets spare part.
     *
     * @return the spare part
     */
    public SparePart getSparePart() {
        return sparePart;
    }

    /**
     * Sets spare part.
     *
     * @param sparePart the spare part
     */
    public void setSparePart(SparePart sparePart) {
        this.sparePart = sparePart;
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
        return "RepairOrder{" +
                "repairOrderId=" + repairOrderId +
                ", repairOrderStartDate=" + repairOrderStartDate +
                ", repairOrderEndDate=" + repairOrderEndDate +
                ", repairOrderIssueDate=" + repairOrderIssueDate +
                ", repairOrderCostEstimated=" + repairOrderCostEstimated +
                ", repairOrderCostTotal=" + repairOrderCostTotal +
                ", client=" + client +
                ", device=" + device +
                ", employee=" + employee +
                ", sparePart=" + sparePart +
                ", status=" + status +
                '}';
    }
}

