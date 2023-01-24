package com.skillstorm.p3one.repository;

import com.skillstorm.p3one.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}