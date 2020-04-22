package main;

import java.util.List;
import java.util.Scanner;

public class ClientUI {
    private Scanner scanner = new Scanner(System.in);

    private UserService userService = UserService.getInstance();
    private CartService cartService = CartService.getInstance();
    private GroceryStoreService groceryStoreService = new GroceryStoreService();

    public static void main(String[] args) {
        ClientUI clientUI = new ClientUI();
        clientUI.loginUser();
        clientUI.menu();
    }

    private void loginUser() {
        System.out.println("\nLogin into the Grocery Store: \n\n");
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter Address");
        String address = scanner.nextLine();
        System.out.println("Enter wallet amount");
        Double walletAmount = scanner.nextDouble();
        userService.createUser(name, address, walletAmount);
    }
    private void displayOptions() {
        System.out.println("\nWelcome to Grocery Store!!. \nPlease choose your options: \n\n");
        System.out.println("1. Display Store Inventory");
        System.out.println("2. Display Store Options");
        System.out.println("3. Display Cart Options");
        System.out.println("0. Log Out");
    }

    private void menu() {
        int choice;
        do {
            displayOptions();
            System.out.println("\nEnter your choice : ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    groceryStoreService.displayStoreProducts();
                    break;
                case 2:
                    storeProductsOptions();
                    storeProductsMenu();
                    break;
                case 3:
                    showCartOptions();
                    showCartMenu();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        } while (choice >= 1 && choice <= 3);
    }


    private void showCartOptions() {
        System.out.println("1. Display Cart");
        System.out.println("2. Add to cart using brand And Category");
        System.out.println("3. Add to cart using Item Id");
        System.out.println("4. Remove from Cart");
        System.out.println("0. Exit");
    }

    private void showCartMenu() {
        System.out.println("\nEnter your choice");
        int ch = scanner.nextInt();
        scanner.nextLine();
        switch (ch) {
            case 1:
                showCart();
                break;
            case 2:
                addProductToCartUsingBrandAndCategory();
                break;
            case 3:
                addProductToCartUsingId();
                break;
            case 4:
                removeProductFromCart();
                break;
            default:
                break;
        }
    }

    private void storeProductsOptions() {
        System.out.println("1. Add Item to Inventory");
        System.out.println("2. Update Item By Price");
        System.out.println("3. Update Item By Quantity");
        System.out.println("0. Exit");
    }

    private void storeProductsMenu() {
        System.out.println("\nEnter your choice");
        int ch = scanner.nextInt();
        scanner.nextLine();
        switch (ch) {
            case 1:
                getItemDetails();
                break;
            case 2:
                updateItemPrice();
                break;
            case 3:
                updateItemQuantity();
                break;
            default:
                break;
        }
    }

    private void getItemDetails() {
        Item item = new Item();
        System.out.println("Enter the category");
        String category = scanner.nextLine();
        item.setCategory(category);
        System.out.println("Enter the brand");
        String brand = scanner.nextLine();
        item.setBrand(brand);
        System.out.println("Enter the price");
        Double price = scanner.nextDouble();
        item.setPrice(price);
        System.out.println("Enter the quantity");
        item.setPrice(price);
        Integer quantity = scanner.nextInt();
        item.setStock(quantity);
        groceryStoreService.addItemToInventory(item);
    }

    private void updateItemPrice() {
        System.out.println("Enter the ItemId");
        Integer itemId = scanner.nextInt();
        System.out.println("Enter the price");
        Double price = scanner.nextDouble();
        scanner.nextLine();
        try {
            groceryStoreService.updateItemPrice(itemId, price);
        }
        catch (Exception e)
        {
            System.out.println("Item does not exist");
        }
    }

    private void updateItemQuantity() {
        System.out.println("Enter the ItemId");
        Integer itemId = scanner.nextInt();
        System.out.println("Enter the price");
        Integer quantity = scanner.nextInt();
        try {
            groceryStoreService.updateItemQuantity(itemId, quantity);
        }
        catch (Exception e)
        {
            System.out.println("Item does not exist");
        }
    }

    private void addProductToCartUsingBrandAndCategory() {
        System.out.println("Enter the product brand");
        String brand = scanner.nextLine();
        System.out.println("Enter the product category");
        String category = scanner.nextLine();
        try {
            Integer itemId = cartService.addProductToCartByBrandAndCategory(brand, category);
            System.out.println("Item added to card with item Id : " + itemId);
        }
        catch (Exception e)
        {
            System.out.println("Item does not exist");
        }
    }

    private void addProductToCartUsingId()
    {
        System.out.println("Enter Item Id");
        Integer itemId = scanner.nextInt();
        try {
            Integer id = cartService.addProductCartByItemId(itemId);
            System.out.println("Item added to card with item Id : " + itemId);
        }
        catch (Exception e)
        {
            System.out.println("Item does not exist");
        }
    }

    private void showCart() {
        List<Item> cartItems = cartService.getCartItems();
        for (Item item : cartItems)
        {
            System.out.println(item);
        }
    }

    private void removeProductFromCart() {
        System.out.println("Enter the product Id");
        int pid = scanner.nextInt();
        try {
            cartService.removeCartItem(pid);
            System.out.println("Item removed");
        }catch (Exception e)
        {
            System.out.println("Item does not exist");
        }
    }
}
