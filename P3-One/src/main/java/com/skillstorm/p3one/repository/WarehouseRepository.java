package com.skillstorm.p3one.repository;

import com.skillstorm.p3one.entities.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
}