package com.project.groceryStore.services;

import com.project.groceryStore.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private User currentUser = new User("vikash", "Bangalore", 1200.00);

    public void createUser(User user) {
        currentUser = user;
    }

    public User getUser() {
        return currentUser;
    }
}
