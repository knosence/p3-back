package com.skillstrom.projectthree.warehouseapi.controllers;

import com.skillstrom.projectthree.warehouseapi.models.Item;
import com.skillstrom.projectthree.warehouseapi.services.Interfaces.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;


    @GetMapping
    public @ResponseBody Iterable<Item> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public @ResponseBody Item findById(@PathVariable int id) {
        return itemService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Item save(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PutMapping("/{id}")
    public @ResponseBody Item update(@RequestBody Item item, @PathVariable int id) {
        return itemService.update(item, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody void deleteById(@PathVariable int id) {
        itemService.deleteById(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody void delete(@RequestBody Item item) {
        itemService.delete(item);
    }

}
