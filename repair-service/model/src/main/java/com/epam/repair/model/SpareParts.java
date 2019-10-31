package com.epam.repair.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * The type SpareParts.
 */
@Entity
public class SpareParts {

    /**
     * Spare parts id is the primary key.
     */
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer sparePartsId;
    private  String sparePartsName;
    private BigDecimal sparePartsCost;

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

    @Override
    public String toString() {
        return "SpareParts{" +
                "sparePartsId=" + sparePartsId +
                ", sparePartsName='" + sparePartsName + '\'' +
                ", sparePartsCost=" + sparePartsCost +
                '}';
    }
}
