package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 * The type Employee.
 */
@Entity
@Table(name = "employee")
public class Employee {

    /**
     * Device condition id is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "employee_generator")
    @SequenceGenerator(name = "employee_generator",
            sequenceName = "employee_seq", allocationSize = 1)
    @Column(name = "employee_id", updatable = false, nullable = false)
    private Integer employeeId;

    @Column(name = "employee_first_name", length = 40, nullable = false)
    private String firstName;

    @Column(name = "employee_last_name", length = 40, nullable = false)
    private String lastName;

    /**
     * Employee type id is the foreign key (Employee type to employee).
     */
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "employee_type_id")
    private EmployeeType employeeType;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<RepairOrder> repairOrders;

    /**
     * Gets employee id.
     *
     * @return the employee id
     */
    public Integer getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets employee id.
     *
     * @param employeeId the employee id
     */
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets employee type.
     *
     * @return the employee type
     */
    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    /**
     * Sets employee type.
     *
     * @param employeeType the employee type
     */
    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
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
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeType=" + employeeType +
                '}';
    }
}
