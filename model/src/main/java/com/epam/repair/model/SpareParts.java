package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * The type SpareParts.
 */
@Entity
@Table(name = "spare_parts")
public class SpareParts {

    /**
     * Spare parts id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator="spare_parts_generator")
    @SequenceGenerator(name="spare_parts_generator",
            sequenceName="spare_parts_generator", allocationSize=1000)
    @Column(name="spare_parts_id", updatable=false, nullable=false)
    private Integer sparePartsId;

    @Column(name="spare_parts_name", length = 40, nullable=false)
    private  String sparePartsName;

    @Column(name="spare_parts_cost", nullable=false)
    private BigDecimal sparePartsCost;

    @JsonIgnore
    @OneToMany(mappedBy="spareParts")
    private List<Orders> orders;

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
     * Gets spare parts name.
     *
     * @return the spare parts name
     */
    public String getSparePartsName() {
        return sparePartsName;
    }

    /**
     * Sets spare parts name.
     *
     * @param sparePartsName the spare parts name
     */
    public void setSparePartsName(String sparePartsName) {
        this.sparePartsName = sparePartsName;
    }

    /**
     * Gets spare parts cost.
     *
     * @return the spare parts cost
     */
    public BigDecimal getSparePartsCost() {
        return sparePartsCost;
    }

    /**
     * Sets spare parts cost.
     *
     * @param sparePartsCost the spare parts cost
     */
    public void setSparePartsCost(BigDecimal sparePartsCost) {
        this.sparePartsCost = sparePartsCost;
    }

    /**
     * Gets orders.
     *
     * @return the orders
     */
    public List<Orders> getOrders() {
        return orders;
    }

    /**
     * Sets orders.
     *
     * @param orders the orders
     */
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "SpareParts{" +
                "sparePartsId=" + sparePartsId +
                ", sparePartsName='" + sparePartsName + '\'' +
                ", sparePartsCost=" + sparePartsCost +
                '}';
    }
}
