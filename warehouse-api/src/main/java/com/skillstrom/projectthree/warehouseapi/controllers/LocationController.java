package com.skillstrom.projectthree.warehouseapi.controllers;

import com.skillstrom.projectthree.warehouseapi.models.Location;
import com.skillstrom.projectthree.warehouseapi.services.Interfaces.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public Iterable<Location> findAll() {
        return locationService.findAll();
    }

    @GetMapping("/{id}")
    public Location findById(@PathVariable int id) {
        return locationService.findById(id);
    }

    @PutMapping("/{id}")
    public Location update(@RequestBody Location location, @PathVariable int id) {
        return locationService.update(location, id);
    }

    @PostMapping
    public Location save(@RequestBody Location location) {
        return locationService.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        locationService.deleteById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody Location location) {
        locationService.delete(location);
    }


}
