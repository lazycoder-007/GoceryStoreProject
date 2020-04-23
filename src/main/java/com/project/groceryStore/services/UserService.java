package com.project.groceryStore.services;

import com.project.groceryStore.models.User;

public class UserService {

    private static UserService userService = null;

    private User currentUser;

    private UserService() {
    }

    public static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
            return userService;
        }
        return userService;
    }

    public void createUser(String name, String address, Double walletAmount) {
        currentUser = new User(name, address, walletAmount);
    }

    public User getUser() {
        return currentUser;
    }
}
