package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.Warehouse;

public interface WarehouseService {

    Iterable<Warehouse> findAll();

    Warehouse findById(int id);

    Warehouse save(Warehouse warehouse);

    void deleteById(int id);

    Warehouse update(Warehouse warehouse, int id);

}
