package com.skillstorm.p3one.controller;

import com.skillstorm.p3one.entities.Item;
import com.skillstorm.p3one.service.ItemService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/item")
@CrossOrigin(origins = "*")
public class ItemController {

    final
    ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Iterable<Item> findAll() {
        return itemService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Item findById(@PathVariable("id") int id) {
        return itemService.findById(id);
    }

    @PostMapping
    public Item save(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping(value = "/{id}")
    public Item update(@RequestBody Item item, @PathVariable("id") int id) {
        return itemService.update(item, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") int id) {
        itemService.deleteById(id);
    }


}
