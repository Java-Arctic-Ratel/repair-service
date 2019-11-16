package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * The type Status.
 */
@Entity
@Table(name = "status")
public class Status {

    /**
     * Status id is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "status_generator")
    @SequenceGenerator(name = "status_generator",
            sequenceName = "status_seq", allocationSize = 1)
    @Column(name = "status_id", updatable = false, nullable = false)
    private Integer statusId;

    @NotEmpty
    @NotNull
    @Column(name = "status_name", length = 40, nullable = false)
    private String statusName;

    @JsonIgnore
    @OneToMany(mappedBy = "status", cascade = CascadeType.ALL)
    private List<RepairOrder> repairOrders;

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

    @Override
    public String toString() {
        return "Status{" +
                "statusId=" + statusId +
                ", statusName='" + statusName + '\'' +
                '}';
    }
}

