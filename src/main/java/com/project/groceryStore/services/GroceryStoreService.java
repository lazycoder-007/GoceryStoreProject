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

    public void displayStoreProducts() {
        List<Item> items = inventoryService.getItems();
        for (Item prod : items) {
            System.out.println(prod.getPid() + "- " + prod.getCategory() + ", " + prod.getBrand() + ", " +
                    prod.getPrice() + ", " + prod.getStock());
        }
    }

    public void updateItemPrice(Integer itemId, Double price) throws Exception {
        inventoryService.updateItemPrice(itemId, price);
    }

    public void updateItemQuantity(Integer itemId, Integer quantity) throws Exception {
        inventoryService.updateItemQuantity(itemId, quantity);
    }
}