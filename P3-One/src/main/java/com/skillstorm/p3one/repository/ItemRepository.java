package com.skillstorm.p3one.repository;

import com.skillstorm.p3one.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}