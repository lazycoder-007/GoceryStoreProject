package com.project.groceryStore.services;

import com.project.groceryStore.models.Item;

import java.util.List;

public class GroceryStoreService {

    private InventoryService inventoryService = InventoryService.getInstance();

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