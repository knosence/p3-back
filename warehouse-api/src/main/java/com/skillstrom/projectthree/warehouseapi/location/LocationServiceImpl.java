package com.skillstrom.projectthree.warehouseapi.location;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    private final Logger log = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Override
    public Iterable<Location> findAll() {
        return locationRepository.findAll();
    }

    @Override
    public Location findById(int id) {
        return locationRepository.findById(id).orElse(null);
    }

    @Override
    public Location save(Location location) {
        log.info(location.toString());
        if (!locationRepository.existsById(location.getLocationId())) {
            return locationRepository.save(location);
        }
        return null;
    }

    @Override
    public Location update(Location location, int id) {
        if (!locationRepository.existsById(id)) {
            return null;
        }
        location.setLocationId(id);
        return locationRepository.save(location);
    }

    @Override
    public void delete(Location location) {
        locationRepository.delete(location);
    }

    @Override
    public void deleteById(int id) {
        locationRepository.deleteById(id);
    }


}
