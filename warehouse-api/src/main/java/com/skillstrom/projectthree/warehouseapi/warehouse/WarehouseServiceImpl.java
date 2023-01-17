package com.skillstrom.projectthree.warehouseapi.warehouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public Iterable<Warehouse> findAll() {
        return warehouseRepository.findAll();
    }

    @Override
    public Warehouse findById(int id) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(id);
        return warehouse.orElse(null);
    }

    @Override
    public Warehouse save(Warehouse warehouse) {
        if (!warehouseRepository.existsById(warehouse.getWarehouseId())) {
            return warehouseRepository.save(warehouse);
        }
        return null;
    }

    @Override
    public Warehouse update(Warehouse warehouse, int id) {
        if (warehouseRepository.existsById(id)) {
            warehouse.setWarehouseId(id);
            return warehouseRepository.save(warehouse);
        }
        return null;
    }

    @Override
    public void delete(Warehouse warehouse) {
        warehouseRepository.delete(warehouse);
    }

    @Override
    public void deleteById(int id) {
        if (warehouseRepository.existsById(id)) {
            warehouseRepository.deleteById(id);
        }

    }



}
