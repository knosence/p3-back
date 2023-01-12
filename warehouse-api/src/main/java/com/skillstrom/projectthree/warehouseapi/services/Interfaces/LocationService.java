package com.skillstrom.projectthree.warehouseapi.services.Interfaces;

import com.skillstrom.projectthree.warehouseapi.models.Location;
public interface LocationService {

    Iterable<Location> findAll();

    Location findById(int id);

    Location save(Location location);

    Location update(Location location, int id);

    void delete(Location location);

    void deleteById(int id);




}
