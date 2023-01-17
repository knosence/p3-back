package com.skillstrom.projectthree.warehouseapi.item;

import com.skillstrom.projectthree.warehouseapi.item.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {



}
