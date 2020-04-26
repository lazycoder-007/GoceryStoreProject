package com.project.groceryStore.controllers;

import com.project.groceryStore.models.Item;
import com.project.groceryStore.services.GroceryStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
