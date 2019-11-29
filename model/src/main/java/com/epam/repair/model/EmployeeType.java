package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * The type Employee type.
 */
@Entity
@Table(name = "employee_type")
public class EmployeeType {
    /**
     * Employee type is the primary key.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "employee_type_generator")
    @SequenceGenerator(name = "employee_type_generator",
            sequenceName = "employee_type_seq", allocationSize = 1)
    @Column(name = "employee_type_id", updatable = false, nullable = false)
    private Integer employeeTypeId;

    @NotNull(message = "{employeeTypeName.null}")
    @NotBlank(message = "{employeeTypeName.empty}")
    @Size(max = 40, message = "{employeeTypeName.maxSize40}")
    @Column(name = "employee_type_name", length = 40, nullable = false)
    private String employeeTypeName;

    @JsonIgnore
    @OneToMany(mappedBy = "employeeType", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private List<Employee> employees;

    /**
     * Gets employee type id.
     *
     * @return the employee type id
     */
    public Integer getEmployeeTypeId() {
        return employeeTypeId;
    }

    /**
     * Sets employee type id.
     *
     * @param employeeTypeId the employee type id
     */
    public void setEmployeeTypeId(Integer employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    /**
     * Gets employee type name.
     *
     * @return the employee type name
     */
    public String getEmployeeTypeName() {
        return employeeTypeName;
    }

    /**
     * Sets employee type name.
     *
     * @param employeeTypeName the employee type name
     */
    public void setEmployeeTypeName(String employeeTypeName) {
        this.employeeTypeName = employeeTypeName;
    }

    /**
     * Gets employees.
     *
     * @return the employees
     */
    public List<Employee> getEmployees() {
        return employees;
    }

    /**
     * Sets employees.
     *
     * @param employees the employees
     */
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "EmployeeType{" +
                "employeeTypeId=" + employeeTypeId +
                ", employeeTypeName='" + employeeTypeName + '\'' +
                '}';
    }
}
