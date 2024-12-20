package org.icet.service;

import org.icet.model.Item;

import java.util.List;

public interface ItemService {
    void addNewItem(Item item);

    List<Item> getAllItems();

    Item getByName(String name);

    void deleteById(Long itemId);

    void updateItem(Item item);

    void updateItemAvailability(Long itemId);

    List<Item> getAvailableItem();
}
