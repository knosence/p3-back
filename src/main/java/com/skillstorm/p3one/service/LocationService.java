package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.Location;

public interface LocationService {

    Iterable<Location> findAll();

    Location findById(int id);

    Location save(Location location);

    void deleteById(int id);

    Location update(Location location, int id);


}
