package com.skillstrom.projectthree.warehouseapi.employee;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skillstrom.projectthree.warehouseapi.warehouse.Warehouse;
import jdk.jfr.SettingDefinition;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.util.Objects;

@Log
@Entity
@Setter
@Getter
@Table(
        name = "employee"
)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "employee_password")
    private String employeePassword;

    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = true)
    @JsonIgnore
    private Warehouse warehouse;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", userRole='" + userRole + '\'' +
                ", employeePassword='" + employeePassword + '\'' +
                ", warehouse=" + warehouse +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeId == employee.employeeId &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName) &&
                Objects.equals(employeeEmail, employee.employeeEmail) &&
                Objects.equals(userRole, employee.userRole) &&
                Objects.equals(employeePassword, employee.employeePassword) &&
                Objects.equals(warehouse, employee.warehouse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, firstName, lastName, employeeEmail, userRole, employeePassword, warehouse);
    }



}

