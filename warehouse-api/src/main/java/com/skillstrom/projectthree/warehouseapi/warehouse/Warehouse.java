package com.skillstrom.projectthree.warehouseapi.warehouse;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skillstrom.projectthree.warehouseapi.company.Company;
import com.skillstrom.projectthree.warehouseapi.employee.Employee;
import com.skillstrom.projectthree.warehouseapi.inventory.Inventory;
import com.skillstrom.projectthree.warehouseapi.location.Location;
import lombok.*;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;


@Log
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @SequenceGenerator(
            name = "warehouses_sequence",
            sequenceName = "warehouses_sequence",
            allocationSize = 1,
            initialValue = 100
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "warehouses_sequence"
    )
    @Column(name = "warehouse_id", updatable = false)
    private Integer warehouseId;


    @OneToOne
    @JoinColumn(name = "location_id")
    private Location location;

    @Column(name = "warehouse_capacity")
    private int warehouseCapacity;


    @OneToMany(
            mappedBy = "warehouse",
            cascade = ALL,
            orphanRemoval = true
    )
    private Set<Inventory> inventory;

    @OneToMany(mappedBy = "warehouse", cascade = ALL)
    private Set<Employee> employees;

    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "company_id")
    @JsonIgnore
    private Company company;

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseId=" + warehouseId +
                ", location=" + location +
                ", warehouseCapacity=" + warehouseCapacity +
                ", inventory=" + inventory +
                ", employees=" + employees +
                ", company=" + company +
                '}';
    }
}
