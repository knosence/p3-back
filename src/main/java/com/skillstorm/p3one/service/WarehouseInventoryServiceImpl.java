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
        return warehouseInventoryRepository.findById(id).get();
    }

    @Override
    public WarehouseInventory save(WarehouseInventory warehouseInventory) {
        return warehouseInventoryRepository.save(warehouseInventory);
    }

    @Override
    public void deleteById(int id) {
        WarehouseInventory warehouseInventory = warehouseInventoryRepository.findById(id).get();
        warehouseInventoryRepository.delete(warehouseInventory);
    }

    @Override
    public WarehouseInventory update(WarehouseInventory warehouseInventory, Integer id) {

        warehouseInventory.setId(id);
        return warehouseInventoryRepository.save(warehouseInventory);
    }

}
