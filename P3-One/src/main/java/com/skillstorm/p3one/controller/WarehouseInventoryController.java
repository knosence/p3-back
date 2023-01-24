package com.skillstorm.p3one.controller;

import com.skillstorm.p3one.entities.WarehouseInventory;
import com.skillstorm.p3one.service.WarehouseInventoryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/inventory")
@CrossOrigin(origins = "*")
public class WarehouseInventoryController {

    final WarehouseInventoryService warehouseInventoryService;

    public WarehouseInventoryController(WarehouseInventoryService warehouseInventoryService) {
        this.warehouseInventoryService = warehouseInventoryService;
    }

    @GetMapping
    public Iterable<WarehouseInventory> findAll() {
        return warehouseInventoryService.findAll();
    }

    @GetMapping(value = "/{id}")
    public WarehouseInventory findById(@PathVariable("id") int id) {
        return warehouseInventoryService.findById(id);
    }

    @PostMapping
    public WarehouseInventory save(@RequestBody WarehouseInventory warehouseInventory) {
        return warehouseInventoryService.save(warehouseInventory);
    }

    @PutMapping(value = "/{id}")
    public WarehouseInventory update(@RequestBody WarehouseInventory warehouseInventory, @PathVariable("id") int id) {
        return warehouseInventoryService.update(warehouseInventory, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") int id) {
        warehouseInventoryService.deleteById(id);
    }




}
