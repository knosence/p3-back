package com.skillstrom.projectthree.warehouseapi.item;

public interface ItemService {

    Iterable<Item> findAll();

    Item findById(int id);

    Item create(Item item);

    Item update(Item item, int id);

    void delete(Item item);

    void deleteById(int id);

}
