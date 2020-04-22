package main;

public class UserService {

    static private UserService userService = null;

    User currentUser;

    private UserService() {
    }

    static UserService getInstance() {
        if (userService == null) {
            userService = new UserService();
            return userService;
        }
        return userService;
    }

    void createUser(String name, String address, Double walletAmount) {
        currentUser = new User(name, address, walletAmount);
    }

    User getUser() {
        return currentUser;
    }
}
