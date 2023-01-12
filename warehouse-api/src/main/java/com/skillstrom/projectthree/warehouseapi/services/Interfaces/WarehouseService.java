package com.skillstrom.projectthree.warehouseapi.services.Interfaces;

import com.skillstrom.projectthree.warehouseapi.models.Warehouse;

public interface WarehouseService {

    Iterable<Warehouse> findAll();

    Warehouse findById(int id);

    Warehouse save(Warehouse warehouse);

    Warehouse update(Warehouse warehouse, int id);

    void delete(Warehouse warehouse);

    void deleteById(int id);


}
