package com.skillstorm.p3one.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "warehouse")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "location_id", nullable = false)
    @JsonBackReference(value = "warehouse-location")
    private Location location;

    @Column(name = "warehouse_capacity", nullable = false)
    private Integer warehouseCapacity;

    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonBackReference(value = "company-warehouse")
    private Company company;

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference(value = "warehouse-employee")
    private Set<Employee> employees = new LinkedHashSet<>();

    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference(value = "warehouse-inventory")
    private Set<WarehouseInventory> warehouseInventories = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(Integer warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<WarehouseInventory> getWarehouseInventories() {
        return warehouseInventories;
    }

    public void setWarehouseInventories(Set<WarehouseInventory> warehouseInventories) {
        this.warehouseInventories = warehouseInventories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Warehouse warehouse = (Warehouse) o;
        return Objects.equals(getId(), warehouse.getId()) && Objects.equals(getLocation(), warehouse.getLocation()) && Objects.equals(getWarehouseCapacity(), warehouse.getWarehouseCapacity()) && Objects.equals(getCompany(), warehouse.getCompany()) && Objects.equals(getEmployees(), warehouse.getEmployees()) && Objects.equals(getWarehouseInventories(), warehouse.getWarehouseInventories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLocation(), getWarehouseCapacity(), getCompany(), getEmployees(), getWarehouseInventories());
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", location=" + location +
                ", warehouseCapacity=" + warehouseCapacity +
                ", company=" + company +
                ", employees=" + employees +
                ", warehouseInventories=" + warehouseInventories +
                '}';
    }
}