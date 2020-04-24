package com.project.groceryStore.services;

import com.project.groceryStore.models.Item;
import com.project.groceryStore.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {

    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private UserService userService;

    private Integer itemId = 0;
    private Map<Integer, Item> itemStorage = new HashMap<>();

    public Integer addProductToCartByBrandAndCategory(String brand, String category) throws Exception {
        Item item = inventoryService.getItemByBrandAndCategory(brand, category);
        User user = userService.getUser();
        if (item.getPrice() <= user.getWalletAmount()) {
            itemStorage.put(itemId++, item);
            user.decreaseWalletAmount(item.getPrice());
            return itemId;
        }
        throw new Exception();
    }

    public Integer addProductCartByItemId(Integer Id) throws Exception {
        Item item = inventoryService.getItemById(Id);
        if (item.getPrice() <= userService.getUser().getWalletAmount()) {
            itemStorage.put(itemId++, item);
            return itemId;
        }
        throw new Exception();
    }

    public List<Item> getCartItems() {
        return new ArrayList<>(itemStorage.values());
    }

    public void removeCartItem(Integer itemId) throws Exception {
        if (itemStorage.get(itemId) == null) {
            throw new Exception();
        }
        Item item = itemStorage.get(itemId);
        User user = userService.getUser();
        user.increaseWalletAmount(item.getPrice());
        itemStorage.remove(itemId);
    }
}