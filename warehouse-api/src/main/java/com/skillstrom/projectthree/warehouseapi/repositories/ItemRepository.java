package com.skillstrom.projectthree.warehouseapi.repositories;

import com.skillstrom.projectthree.warehouseapi.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {


}
