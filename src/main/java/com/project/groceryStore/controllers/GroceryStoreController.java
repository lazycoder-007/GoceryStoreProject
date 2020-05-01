package com.project.groceryStore.controllers;

import com.project.groceryStore.models.Item;
import com.project.groceryStore.services.GroceryStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping(value = "/groceryStore")
@RestController
public class GroceryStoreController {

    @Autowired
    GroceryStoreService groceryStoreService;

    @RequestMapping(method = RequestMethod.GET, value = "")
    public List<Item> getProducts() {
        return groceryStoreService.getStoreProducts();
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public void addItemToInventory(@RequestBody Item item) {
        groceryStoreService.addItemToInventory(item);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{itemId}/{price}")
    public void updateItemPrice(@RequestParam Integer itemId, @RequestParam Double price) throws Exception {
        groceryStoreService.updateItemPrice(itemId, price);
    }
}
