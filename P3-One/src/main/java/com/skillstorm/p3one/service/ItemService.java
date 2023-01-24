package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.Item;

public interface ItemService {

    Iterable<Item> findAll();

    Item findById(int id);

    Item save(Item item);

    void deleteById(int id);

    Item update(Item item, int id);


}
