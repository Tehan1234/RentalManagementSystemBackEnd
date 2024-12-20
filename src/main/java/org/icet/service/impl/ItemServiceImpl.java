package org.icet.service.impl;

import lombok.RequiredArgsConstructor;
import org.icet.entity.ItemEntity;
import org.icet.model.Item;
import org.icet.repository.ItemRepository;
import org.icet.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Primary
@RequiredArgsConstructor

public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    private final ModelMapper modelMapper;


    @Override
    public void addNewItem(Item item) {
        item.setAvailability("available");
        itemRepository.save(modelMapper.map(item, ItemEntity.class));
    }

    @Override
    public List<Item> getAllItems() {
        List<Item> itemList = new ArrayList<>();
        itemRepository.findAll().forEach(itemEntity -> {
            itemList.add(modelMapper.map(itemEntity, Item.class));
        });
        return itemList;
    }

    @Override
    public Item getByName(String name) {
        return modelMapper.map(itemRepository.findByName(name), Item.class);
    }

    @Override
    public void deleteById(Long itemId) {
        itemRepository.deleteById(itemId);
    }

    @Override
    public void updateItem(Item item) {
        itemRepository.save(modelMapper.map(item, ItemEntity.class));
    }

    @Override
    public void updateItemAvailability(Long itemId) {
        Optional<ItemEntity> itemEntity = itemRepository.findById(itemId);
        if (itemEntity.isPresent()) {
            ItemEntity itemEntity1 = itemEntity.get();
            itemEntity1.setAvailability("occupied");
            itemRepository.save(itemEntity1);
        }
    }

    @Override
    public List<Item> getAvailableItem() {
        List<ItemEntity> availableRooms = itemRepository.findByAvailability("available");
        List<Item> itemList = new ArrayList<>();

        availableRooms.forEach(ItemEntity -> {
            Item itemDto = modelMapper.map(ItemEntity, Item.class);
            itemList.add(itemDto);
        });

        return itemList;
    }
}
