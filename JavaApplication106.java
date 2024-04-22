package javaapplication106;
import java.util.Scanner;
public class JavaApplication106 {
    public static void main(String[] args) {
               Scanner scanner = new Scanner(System.in);
        // Create electronic product
        ElectronicProduct electronicProduct = new ElectronicProduct(1, "smartphone", 599.9f, "Samsung", 1);
        // Create clothing product
        ClothingProduct clothingProduct = new ClothingProduct(2, "T-shirt", 19.99f, "Medium", "Cotton");
        // Create book product
        BookProduct bookProduct = new BookProduct(3, "OOP", 39.99f, "O’Reilly", "X Publications");
        // Get customer information
        System.out.println("Welcome to the Eccomerse System!");
        System.out.println("please enter your id : ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.println("please Enter your name: ");
        String name = scanner.nextLine();
        System.out.println("please Enter your address: ");
        String address = scanner.nextLine();
        // Create customer
        Customer customer = new Customer(customerId, name, address);
        // Create shopping cart
        System.out.println("How many products yo want to add to your cart ? ");
        int numProducts = scanner.nextInt();
        Cart cart = new Cart(customer.getCustomerId(), numProducts);
        // Add products to cart
        for (int i = 0; i < numProducts; i++) {
            System.out.println("Enter product details for product " + (i + 1) + ":");
           System.out.println("Enter product type (1- SmartPhone , 2- T-shirt, 3-OOP):");
            int productType = scanner.nextInt();
            //scanner.nextLine(); // Consume newline character
            Product product;
            switch (productType) {
                case 1:
                    product = electronicProduct;
                    break;
                case 2:
                    product = clothingProduct;
                    break;
                case 3:
                    product = bookProduct;
                    break;
                default:
                    System.out.println("Invalid product type. Defaulting to electronic product.");
                    product = electronicProduct;
            }
            cart.addProduct(product, i);
        }
        // Ask user if they want to place order
        System.out.println("Do you want to place the order? (yes/no)");
        String choice = scanner.next();
        if (choice.equalsIgnoreCase("yes")) {
            // Place order
            Order order = cart.placeOrder();
            // Print order info
            System.out.println("Here's your order summary : ");
            order.printOrderInfo();
        } else {
            System.out.println("Order not placed. Exiting...");
        }
    }
}

