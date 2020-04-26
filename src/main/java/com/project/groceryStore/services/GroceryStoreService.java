package com.project.groceryStore.services;

import com.project.groceryStore.models.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryStoreService {

    @Autowired
    private InventoryService inventoryService;

    public void addItemToInventory(Item item) {
        inventoryService.addItem(item);
    }

    public List<Item> getStoreProducts() {
        return inventoryService.getItems();
    }

    public void updateItemPrice(Integer itemId, Double price) throws Exception {
        inventoryService.updateItemPrice(itemId, price);
    }

    public void updateItemQuantity(Integer itemId, Integer quantity) throws Exception {
        inventoryService.updateItemQuantity(itemId, quantity);
    }
}