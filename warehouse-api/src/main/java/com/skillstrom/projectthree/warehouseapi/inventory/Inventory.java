package com.skillstrom.projectthree.warehouseapi.inventory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skillstrom.projectthree.warehouseapi.item.Item;
import com.skillstrom.projectthree.warehouseapi.warehouse.Warehouse;
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
        name = "warehouse_inventory"
)
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Integer inventoryId;

    @Column(name = "item_quantity")
    private int itemQuantity;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    @JsonIgnore
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    @Override
    public String toString() {
        return "Inventory{" +
                "inventoryId=" + inventoryId +
                ", itemQuantity=" + itemQuantity +
                ", warehouse=" + warehouse +
                ", item=" + item +
                '}';
    }

}
