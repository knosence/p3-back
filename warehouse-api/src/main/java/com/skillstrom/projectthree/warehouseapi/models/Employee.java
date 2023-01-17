package com.skillstrom.projectthree.warehouseapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.util.List;

@Log
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "warehouse_id")
    @JsonIgnore
    private Warehouse warehouse;



}

