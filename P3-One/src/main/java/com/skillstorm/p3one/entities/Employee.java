package com.skillstorm.p3one.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "Last_name", nullable = false, length = 40)
    private String lastName;

    @Column(name = "employee_email", nullable = false, length = 50)
    private String employeeEmail;

    @Column(name = "employee_password", nullable = false, length = 30)
    private String employeePassword;

    @Column(name = "user_role", nullable = false, length = 20)
    private String userRole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getId(), employee.getId()) && Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getEmployeeEmail(), employee.getEmployeeEmail()) && Objects.equals(getEmployeePassword(), employee.getEmployeePassword()) && Objects.equals(getUserRole(), employee.getUserRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmployeeEmail(), getEmployeePassword(), getUserRole());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeePassword='" + employeePassword + '\'' +
                ", userRole='" + userRole + '\'' +
                '}';
    }
}