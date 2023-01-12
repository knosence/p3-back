package com.skillstrom.projectthree.warehouseapi.repositories;

import com.skillstrom.projectthree.warehouseapi.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Integer> {


}