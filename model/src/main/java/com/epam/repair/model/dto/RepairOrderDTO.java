package com.epam.repair.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The type order dto.
 */
public class RepairOrderDTO {

    private Integer repairOrderId;
    private LocalDate repairOrderStartDate;
    private LocalDate repairOrderEndDate;
    private BigDecimal repairOrderCostEstimated;
    private ClientDTO client;
    private DeviceDTO device;
    private StatusDTO status;

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
     * Gets client.
     *
     * @return the client
     */
    public ClientDTO getClient() {
        return client;
    }

    /**
     * Sets client.
     *
     * @param client the client
     */
    public void setClient(ClientDTO client) {
        this.client = client;
    }

    /**
     * Gets device.
     *
     * @return the device
     */
    public DeviceDTO getDevice() {
        return device;
    }

    /**
     * Sets device.
     *
     * @param device the device
     */
    public void setDevice(DeviceDTO device) {
        this.device = device;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public StatusDTO getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(StatusDTO status) {
        this.status = status;
    }
}

