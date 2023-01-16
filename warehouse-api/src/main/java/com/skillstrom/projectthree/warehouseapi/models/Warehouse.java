package com.skillstrom.projectthree.warehouseapi.models;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
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
    private int warehouseId;


    @Column(name = "warehouse_address")
    private int warehouseAddress;

    @Column(name = "warehouse_capacity")
    private int warehouseCapacity;

    @Column(name = "company")
    private int company;

    @ManyToMany
    @JoinTable(
            name = "warehouse_employee",
            joinColumns = @JoinColumn(name = "warehouse_id"),
            inverseJoinColumns = @JoinColumn(name = "item_quantity")
    )
    private Set<Item> inventory = new HashSet<>();

    public Set<Item> getItems() {
        return inventory;
    }

    public void setItems(Item items) {
        this.inventory.add(items);
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(int warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public int getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(int warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }

    public int getCompany() {
        return company;
    }

    public void setCompany(int company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseId=" + warehouseId +
                ", warehouseAddress=" + warehouseAddress +
                ", warehouseCapacity=" + warehouseCapacity +
                ", companyId=" + company +
                '}';
    }


}
