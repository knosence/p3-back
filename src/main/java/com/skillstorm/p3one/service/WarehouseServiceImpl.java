package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.Employee;
import com.skillstorm.p3one.entities.Warehouse;
import com.skillstorm.p3one.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

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
        return warehouseRepository.findById(id).get();
    }

    @Override
    public Warehouse save(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public void deleteById(int id) {
        Warehouse warehouse = warehouseRepository.findById(id).get();
        warehouseRepository.delete(warehouse);
    }

    @Override
    public Warehouse update(Warehouse warehouse, int id) {
        warehouse.setId(id);
        return warehouseRepository.save(warehouse);
    }
}
