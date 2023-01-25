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
        return locationRepository.findById(id).get(); //.orElseThrow(() -> new RuntimeException("Location not found"));
    }

    @Override
    public Location save(Location location) {
        //if (location.getId() != 0) {
        //    throw new RuntimeException("Location already exists");
        //}
        return locationRepository.save(location);
    }

    @Override
    public void deleteById(int id) {
        //locationRepository.findById(id).orElseThrow(() -> new RuntimeException("Location not found"));
        locationRepository.deleteById(id);
    }

    @Override
    public Location update(Location location, int id) {
        //Location location1 = locationRepository.findById(id).get();

        location.setId(id);
        //location1.setCity(location.getCity());
        //location1.setState(location.getState());
        //location1.setState(location.getState());
        //location1.setPostalCode(location.getPostalCode());
        //location1.setStreetAddress(location.getStreetAddress());
        return locationRepository.save(location);
    }

}
