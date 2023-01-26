package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.Location;
import com.skillstorm.p3one.repository.LocationRepository;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    final
    LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        super();
        this.locationRepository = locationRepository;
    }

    @Override
    public Iterable<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location findById(int id) {
        return locationRepository.findById(id).get();
    }

    @Override
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public void deleteById(int id) {
        Location location = locationRepository.findById(id).get();
        locationRepository.delete(location);
    }

    @Override
    public Location update(Location location, int id) {
        location.setId(id);
        return locationRepository.save(location);
    }

}
