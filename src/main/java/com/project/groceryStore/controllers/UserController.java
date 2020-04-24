package com.project.groceryStore.controllers;

import com.project.groceryStore.models.User;
import com.project.groceryStore.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public void loginUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "")
    public User getUser() {
        return userService.getUser();
    }
}
