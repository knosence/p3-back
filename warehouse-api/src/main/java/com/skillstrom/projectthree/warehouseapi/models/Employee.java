package com.skillstrom.projectthree.warehouseapi.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Employee")
@Table(
        name = "employee",
        uniqueConstraints = {@UniqueConstraint(name = "employee_email_unique", columnNames = "employee_email")}
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

    @ManyToMany
    @Column(name = "warehouse_id")
    private List<Location> warehouseId;

    @Column(name = "employee_email")
    private String employeeEmail;

    @Column(name = "user_role")
    private String userRole;

    @Column(name = "password")
    private String password;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Location> getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(List<Location> warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", warehouseId=" + warehouseId +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", userRole='" + userRole + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
