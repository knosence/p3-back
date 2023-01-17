package com.skillstrom.projectthree.warehouseapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.extern.java.Log;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Log
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @JsonIgnore
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
