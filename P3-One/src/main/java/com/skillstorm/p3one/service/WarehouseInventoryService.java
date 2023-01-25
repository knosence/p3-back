package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.WarehouseInventory;

public interface WarehouseInventoryService {

    Iterable<WarehouseInventory> findAll();

    WarehouseInventory findById(int id);

    WarehouseInventory save(WarehouseInventory warehouseInventory);

    void deleteById(int id);

    WarehouseInventory update(WarehouseInventory warehouseInventory, Integer id);


}
