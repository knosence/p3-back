package com.skillstrom.projectthree.warehouseapi.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skillstrom.projectthree.warehouseapi.inventory.Inventory;
import lombok.Data;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.util.Set;


@Log
@Entity
@Data
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private int itemId;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_description")
    private String itemDescription;

    @Column(name = "item_size")
    private int itemSize;

    @OneToMany(mappedBy = "item" , cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Inventory> inventory;


}
