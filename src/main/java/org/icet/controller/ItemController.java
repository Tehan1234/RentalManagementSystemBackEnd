package org.icet.controller;

import lombok.RequiredArgsConstructor;
import org.icet.model.Item;
import org.icet.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/item")
@RequiredArgsConstructor

public class ItemController {

    private final ItemService itemService;

    @PostMapping("/add-new-item")
    public void addNewItem(@RequestBody Item item) {
        itemService.addNewItem(item);
    }

    @GetMapping("/get-all-items")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/searchByName/{name}")
    public Item getByName(@PathVariable String name) {
        return itemService.getByName(name);
    }

    @DeleteMapping("/delete-by-id/{itemId}")
    public void deleteById(@PathVariable Long itemId) {
        itemService.deleteById(itemId);
    }

    @PutMapping("/update-item")
    public void updateItem(@RequestBody Item item) {
        itemService.updateItem(item);
    }

    @GetMapping("/available-items")
    public ResponseEntity<List<Item>> getAvailableRooms() {
        List<Item> availableRooms = itemService.getAvailableItem();
        return ResponseEntity.ok(availableRooms);
    }

    public void changeItemAvailability(Long itemId) {
        itemService.updateItemAvailability(itemId);
    }
}
