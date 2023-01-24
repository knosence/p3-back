package com.skillstorm.p3one.repository;

import com.skillstorm.p3one.entities.WarehouseInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseInventoryRepository extends JpaRepository<WarehouseInventory, Integer> {
}