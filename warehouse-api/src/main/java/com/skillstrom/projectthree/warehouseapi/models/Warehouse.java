package com.skillstrom.projectthree.warehouseapi.models;


import javax.persistence.*;

@Entity
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehouse_id", updatable = false)
    private int warehouseId;

    @Column(name = "warehouse_name")
    private String warehouseName;

    @Column(name = "warehouse_address")
    private Location warehouseAddress;

    @Column(name = "warehouse_capacity")
    private int warehouseCapacity;

    @Column(name = "company")
    private Company company;

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Location getWarehouseAddress() {
        return warehouseAddress;
    }

    public void setWarehouseAddress(Location warehouseAddress) {
        this.warehouseAddress = warehouseAddress;
    }

    public int getWarehouseCapacity() {
        return warehouseCapacity;
    }

    public void setWarehouseCapacity(int warehouseCapacity) {
        this.warehouseCapacity = warehouseCapacity;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Warehouse{" +
                "warehouseId=" + warehouseId +
                ", warehouseName='" + warehouseName + '\'' +
                ", warehouseAddress=" + warehouseAddress +
                ", warehouseCapacity=" + warehouseCapacity +
                ", companyId=" + company +
                '}';
    }
}
