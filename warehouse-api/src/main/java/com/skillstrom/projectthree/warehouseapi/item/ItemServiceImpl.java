package com.skillstrom.projectthree.warehouseapi.item;

import com.skillstrom.projectthree.warehouseapi.item.Item;
import com.skillstrom.projectthree.warehouseapi.item.ItemRepository;
import com.skillstrom.projectthree.warehouseapi.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Iterable<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item findById(int id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.orElse(null);
    }

    @Override
    public Item save(Item item) {
        if (!itemRepository.existsById(item.getItemId())) {
            return itemRepository.save(item);
        }
        return null;
    }

    @Override
    public Item update(Item item, int id) {
        if (itemRepository.existsById(id)) {
            item.setItemId(id);
            return itemRepository.save(item);
        }
        return null;
    }

    @Override
    public void delete(Item item) {
        itemRepository.delete(item);
    }

    @Override
    public void deleteById(int id) {
        if (itemRepository.existsById(id)) {
            itemRepository.deleteById(id);
        }

    }
}
