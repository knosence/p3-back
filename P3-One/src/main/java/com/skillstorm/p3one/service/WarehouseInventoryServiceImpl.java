package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.WarehouseInventory;
import com.skillstorm.p3one.repository.WarehouseInventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static sun.security.ssl.SSLLogger.info;

@Service
public class WarehouseInventoryServiceImpl implements WarehouseInventoryService {
    private final WarehouseInventoryRepository warehouseInventoryRepository;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    public WarehouseInventoryServiceImpl(WarehouseInventoryRepository warehouseInventoryRepository) {
        super();
        this.warehouseInventoryRepository = warehouseInventoryRepository;
    }

    @Override
    public Iterable<WarehouseInventory> findAll() {
        return warehouseInventoryRepository.findAll();
    }

    @Override
    public WarehouseInventory findById(int id) {
        return warehouseInventoryRepository.findById(id).get(); //.orElseThrow(() -> new RuntimeException("Warehouse Inventory not found"));
    }

    @Override
    public WarehouseInventory save(WarehouseInventory warehouseInventory) {
        //if (warehouseInventory.getId() != 0) {
        //    throw new RuntimeException("Warehouse Inventory already exists");
        //}
        return warehouseInventoryRepository.save(warehouseInventory);
    }

    @Override
    public void deleteById(int id) {
        //warehouseInventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse Inventory not found"));
        WarehouseInventory warehouseInventory = warehouseInventoryRepository.findById(id).get();
        warehouseInventoryRepository.delete(warehouseInventory);
    }

    @Override
    public WarehouseInventory update(WarehouseInventory warehouseInventory, Integer id) {
        //WarehouseInventory warehouseInventory1 = warehouseInventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse Inventory not found"));
        //logger.info("Warehouse Inventory updated" + warehouseInventory1 + "or" + warehouseInventory);
        warehouseInventory.setId(id);
        return warehouseInventoryRepository.save(warehouseInventory);
    }

}
