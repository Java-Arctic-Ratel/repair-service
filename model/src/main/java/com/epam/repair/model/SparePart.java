package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The type SpareParts.
 */
@Entity
@Table(name = "spare_part")
public class SparePart {

    /**
     * Spare part id is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "spare_part_generator")
    @SequenceGenerator(name = "spare_part_generator",
            sequenceName = "spare_part_seq", allocationSize = 1)
    @Column(name = "spare_part_id", updatable = false, nullable = false)
    private Integer sparePartId;

    @Column(name = "spare_part_name", length = 40, nullable = true)
    private String sparePartName;

    @Column(name = "spare_part_cost", nullable = true)
    private BigDecimal sparePartCost;

    @JsonIgnore
    @OneToMany(mappedBy = "sparePart", cascade = CascadeType.ALL)
    private List<RepairOrder> repairOrders;

    /**
     * Gets spare part id.
     *
     * @return the spare part id
     */
    public Integer getSparePartId() {
        return sparePartId;
    }

    /**
     * Sets spare part id.
     *
     * @param sparePartId the spare part id
     */
    public void setSparePartId(Integer sparePartId) {
        this.sparePartId = sparePartId;
    }

    /**
     * Gets spare part name.
     *
     * @return the spare part name
     */
    public String getSparePartName() {
        return sparePartName;
    }

    /**
     * Sets spare part name.
     *
     * @param sparePartName the spare part name
     */
    public void setSparePartName(String sparePartName) {
        this.sparePartName = sparePartName;
    }

    /**
     * Gets spare parts cost.
     *
     * @return the spare parts cost
     */
    public BigDecimal getsparePartCost() {
        return sparePartCost;
    }

    /**
     * Sets spare parts cost.
     *
     * @param sparePartCost the spare parts cost
     */
    public void setsparePartCost(BigDecimal sparePartCost) {
        this.sparePartCost = sparePartCost;
    }

    /**
     * Gets repair orders.
     *
     * @return the repair orders
     */
    public List<RepairOrder> getRepairOrders() {
        return repairOrders;
    }

    /**
     * Sets repair orders.
     *
     * @param repairOrders the repair orders
     */
    public void setRepairOrders(List<RepairOrder> repairOrders) {
        this.repairOrders = repairOrders;
    }

    @Override
    public String toString() {
        return "SparePart{" +
                "sparePartId=" + sparePartId +
                ", sparePartName='" + sparePartName + '\'' +
                ", sparePartCost=" + sparePartCost +
                '}';
    }
}
