package com.skillstorm.p3one.service;

import com.skillstorm.p3one.entities.Item;
import com.skillstorm.p3one.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    final
    ItemRepository itemRepository;


    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        super();
        this.itemRepository = itemRepository;
    }


    @Override
    public Iterable<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(int id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteById(int id) {
        Item item1 = itemRepository.findById(id).get();
        itemRepository.delete(item1);
    }

    @Override
    public Item update(Item item, int id) {
        item.setId(id);
        return itemRepository.save(item);

    }
}
