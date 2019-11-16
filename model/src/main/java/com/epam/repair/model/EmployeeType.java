package com.epam.repair.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @NotEmpty
    @NotNull
    @Column(name = "employee_type_name", length = 40, nullable = false)
    private String employeeTypeName;

    @JsonIgnore
    @OneToMany(mappedBy = "employeeType", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Integer getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(Integer employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public String getEmployeeTypeName() {
        return employeeTypeName;
    }

    public void setEmployeeTypeName(String employeeTypeName) {
        this.employeeTypeName = employeeTypeName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "EmployeeType{" +
                "employeeTypeId=" + employeeTypeId +
                ", employeeTypeName='" + employeeTypeName + '\'' +
                ", employees=" + employees +
                '}';
    }
}
