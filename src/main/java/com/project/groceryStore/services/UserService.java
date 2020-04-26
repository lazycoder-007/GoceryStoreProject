package com.project.groceryStore.services;

import com.project.groceryStore.models.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<String, User> userDataStorage = new HashMap<>();
    private User currentUser = null;

    public void createUser(User user) {
        userDataStorage.put(user.getName(), user);
        currentUser = user;
    }

    public User getUser(String name) throws Exception {
        if (userDataStorage.get(name) == null) {
            throw new Exception("User not logged in");
        }
        return userDataStorage.get(name);
    }

    public User getCurrentUser() throws Exception {
        if (currentUser == null) {
            throw new Exception("USer not logged in");
        }
        return currentUser;
    }
}
