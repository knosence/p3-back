package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.Warehouse;
import com.skillstorm.p3one.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private final WarehouseRepository warehouseRepository;

    @Autowired
    public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
        super();
        this.warehouseRepository = warehouseRepository;
    }


    @Override
    public Iterable<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }

    @Override
    public Warehouse findById(int id) {
        return warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse not found"));
    }

    @Override
    public Warehouse save(Warehouse warehouse) {
        if (warehouse.getId() != 0) {
            throw new RuntimeException("Warehouse already exists");
        }
        return warehouseRepository.save(warehouse);
    }

    @Override
    public void deleteById(int id) {
        warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse not found"));
        warehouseRepository.deleteById(id);
    }

    @Override
    public Warehouse update(Warehouse warehouse, int id) {
        Warehouse warehouse1 = warehouseRepository.findById(id).orElseThrow(() -> new RuntimeException("Warehouse not found"));

        warehouse1.setId(id);
        warehouse1.setWarehouseCapacity(warehouse.getWarehouseCapacity());
        warehouse1.setLocation(warehouse.getLocation());
        warehouse1.setEmployees(warehouse.getEmployees());
        warehouse1.setWarehouseInventories(warehouse.getWarehouseInventories());
        return warehouseRepository.save(warehouse1);
    }
}
