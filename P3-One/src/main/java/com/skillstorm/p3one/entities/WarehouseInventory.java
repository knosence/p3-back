package com.skillstorm.p3one.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "warehouse_inventory")
public class WarehouseInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "item_id", nullable = false)
    @JsonBackReference(value = "warehouse-item")
    private Item item;


    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "warehouse_id", nullable = false)
    @JsonBackReference(value = "warehouse-inventory")
    private Warehouse warehouse;

    @Column(name = "item_quantity", nullable = false)
    private Integer itemQuantity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(Integer itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WarehouseInventory that = (WarehouseInventory) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getItem(), that.getItem()) && Objects.equals(getWarehouse(), that.getWarehouse()) && Objects.equals(getItemQuantity(), that.getItemQuantity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getItem(), getWarehouse(), getItemQuantity());
    }

    @Override
    public String toString() {
        return "WarehouseInventory{" +
                "id=" + id +
                ", item=" + item +
                ", warehouse=" + warehouse +
                ", itemQuantity=" + itemQuantity +
                '}';
    }
}