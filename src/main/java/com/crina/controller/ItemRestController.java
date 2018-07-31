package com.crina.controller;

import com.crina.model.Item;
import com.crina.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/items")
public class ItemRestController {

    @Autowired
    private ItemRepository repository;

    @PostMapping(value = "/addItem")
    public Item addItem(@RequestBody final Item item) {
        repository.save(item);
        return repository.findByName(item.getName());

    }

  /*  @GetMapping
    public ResponseEntity<Collection<Item>> getAllItems() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }*/

    @GetMapping
    public List<Item> getAllItems() {
        return repository.findAll();
    }

   /* @GetMapping(value = "/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable Integer id) {
        return new ResponseEntity<>(repository.findOne(id), HttpStatus.OK);
    }*/

   @GetMapping(value = "/{id}")
   public Item getItemById(@PathVariable Integer id){
       Optional<Item> itemById = repository.findById(id);
       Item item = new Item(itemById.get().getName(), itemById.get().getLevel());
       return item;
   }

    /*
    @GetMapping(value = "/name")
    public ResponseEntity<Collection<Item>> findItemByName(@RequestParam(value = "name") String name) {
        return new ResponseEntity<>(repository.findByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/{name}")
    public Item findItemByName(@RequestParam(value="name") String name) {
        return repository.findByName(name);
    }*/

    @PutMapping(value = "/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable("id") Integer id, @RequestBody Item item ) {
        Item currentItem = repository.getOne(id);
        currentItem.setName(item.getName());
        currentItem.setLevel(item.getLevel());
        return new ResponseEntity<>(repository.save(currentItem), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteItemWithId(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllItems() {
        repository.deleteAll();
    }
}
