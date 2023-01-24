package com.skillstorm.p3one.controller;

import com.skillstorm.p3one.entities.Location;
import com.skillstorm.p3one.service.LocationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/location")
@CrossOrigin(origins = "*")
public class LocationController {

    final
    LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public Iterable<Location> findAll() {
        return locationService.findAll();
    }

    @GetMapping("/{id}")
    public Location findById(@PathVariable("id") int id) {
        return locationService.findById(id);
    }

    @PutMapping("/{id}")
    public Location update(@RequestBody Location location, @PathVariable("id") int id) {
        return locationService.update(location, id);
    }

    @PostMapping
    public Location save(@RequestBody Location location) {
        return locationService.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id) {
        locationService.deleteById(id);
    }
}
