package com.skillstorm.p3one.controller;

import com.skillstorm.p3one.entities.Warehouse;
import com.skillstorm.p3one.service.WarehouseService;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/warehouse")
@CrossOrigin(origins = "*")
public class WarehouseController {


    final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    public Iterable<Warehouse> findAll() {
        return warehouseService.findAll();
    }

    @GetMapping("/{id}")
    public Warehouse findById(@PathVariable("id") int id) {
        return warehouseService.findById(id);
    }

    @PostMapping
    public Warehouse save(@RequestBody Warehouse warehouse) {
        return warehouseService.save(warehouse);
    }

    @PutMapping("/{id}")
    public Warehouse update(@RequestBody Warehouse warehouse, @PathVariable("id") int id) {
        return warehouseService.update(warehouse, id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        warehouseService.deleteById(id);
    }
    

}
