package com.project.groceryStore.services;

import com.project.groceryStore.models.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InventoryService {
    private static InventoryService inventoryService = null;
    private static HashMap<Integer, Item> itemStorage = new HashMap<>();
    private static Integer itemId = 0;

    private InventoryService() {
    }

    public static InventoryService getInstance() {
        if (inventoryService == null) {
            initStoreItems();
            inventoryService = new InventoryService();
            return inventoryService;
        }
        return inventoryService;
    }

    private static void initStoreItems() {
        String[] productNames = {"Soap", "Face Cream", "Garam Masala"};
        String[] brandNames = {"Lux", "Fair n Lovely", "MTR"};
        Double[] productPrice = {40.00d, 60.00d, 30.00d};
        Integer[] stock = {20, 16, 18};

        for (int i = 0; i < productNames.length; i++) {
            itemId++;
            itemStorage.put(itemId, new Item(itemId, productNames[i], brandNames[i], productPrice[i], stock[i]));
        }
    }

    public List<Item> getItems() {
        return new ArrayList<>(itemStorage.values());
    }

    public Item getItemById(Integer itemId) throws Exception {
        if (itemStorage.get(itemId) == null) {
            throw new Exception();
        }
        return itemStorage.get(itemId);
    }

    public Item getItemByBrandAndCategory(String brand, String category) throws Exception {
        Item item = null;
        for (Item eachItem : itemStorage.values()) {
            if (eachItem.getBrand().equals(brand) && eachItem.getCategory().equals(category)) {
                item = eachItem;
            }
        }
        if (item == null) {
            throw new Exception();
        }
        return item;
    }

    public void addItem(Item item) {
        itemId++;
        item.setPid(itemId);
        itemStorage.put(itemId, item);
    }

    public void updateItemPrice(Integer itemId, Double price) throws Exception {
        if (itemStorage.get(itemId) == null) {
            throw new Exception();
        }
        itemStorage.get(itemId).setPrice(price);
    }

    public void updateItemQuantity(Integer itemId, Integer quantity) throws Exception {
        if (itemStorage.get(itemId) == null) {
            throw new Exception();
        }
        itemStorage.get(itemId).setStock(quantity);
    }
}