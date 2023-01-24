package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.WarehouseInventory;
import com.skillstorm.p3one.repository.WarehouseInventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseInventoryServiceImpl implements WarehouseInventoryService {
    private final WarehouseInventoryRepository warehouseInventoryRepository;

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
        return warehouseInventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse Inventory not found"));
    }

    @Override
    public WarehouseInventory save(WarehouseInventory warehouseInventory) {
        if (warehouseInventory.getId() != 0) {
            throw new RuntimeException("Warehouse Inventory already exists");
        }
        return warehouseInventoryRepository.save(warehouseInventory);
    }

    @Override
    public void deleteById(int id) {
        warehouseInventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse Inventory not found"));
        warehouseInventoryRepository.deleteById(id);
    }

    @Override
    public WarehouseInventory update(WarehouseInventory warehouseInventory, int id) {
        WarehouseInventory warehouseInventory1 = warehouseInventoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse Inventory not found"));

        warehouseInventory1.setId(id);
        warehouseInventory1.setItemQuantity(warehouseInventory.getItemQuantity());
        warehouseInventory1.setWarehouse(warehouseInventory.getWarehouse());
        warehouseInventory1.setItem(warehouseInventory.getItem());
        return warehouseInventoryRepository.save(warehouseInventory1);
    }
}
