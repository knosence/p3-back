package com.skillstrom.projectthree.warehouseapi.item;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skillstrom.projectthree.warehouseapi.inventory.Inventory;
import lombok.*;
import lombok.extern.java.Log;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;


@Log
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
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

    @OneToMany(mappedBy = "item")
    @JsonIgnore
    private Set<Inventory> inventory;




}
