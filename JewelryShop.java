import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private double price;
    private String description;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
ṇ
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

class JewelleryShop {
    private ArrayList<Product> inventory;

    public JewelleryShop() {
        this.inventory = new ArrayList<Product>();
        inventory.add(new Product("Diamond Ring", 5000.00, "Beautiful diamond ring."));
        inventory.add(new Product("Gold Necklace", 3000.00, "Stylish gold necklace."));
        inventory.add(new Product("Silver Bracelet", 1500.00, "Elegant silver bracelet."));
    }

    public void addProduct(Product p) {
        inventory.add(p);
        System.out.println("Product added successfully!");
    }

    public void removeProduct(String name) {
        for (int i = 0; i < inventory.size(); i++) {
            if (inventory.get(i).getName().equalsIgnoreCase(name)) {
                inventory.remove(i);
                System.out.println("Product removed successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public void modifyProduct(String name) {
        for (Product p : inventory) {
            if (p.getName().equalsIgnoreCase(name)) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new price: ");
                double newPrice = 0;
                while (true) {
                    try {
                        newPrice = Double.parseDouble(scanner.nextLine());
                        break;
                    } catch (NumberFormatException e) {
                        System.out.print("Invalid price. Please enter a valid number: ");
                    }
                }
                System.out.print("Enter new description: ");
                String newDesc = scanner.nextLine();
                p.setName(newName);
                p.setPrice(newPrice);
                p.setDescription(newDesc);
                System.out.println("Product modified successfully!");
                return;
            }
        }
        System.out.println("Product not found!");
    }

    public void displayInventory() {
        System.out.println("Product Inventory:");
        for (Product p : inventory) {
            System.out.println("Name: " + p.getName());
            System.out.println("Price: " + p.getPrice());
            System.out.println("Description: " + p.getDescription());
            System.out.println("--------------------------");
        }
    }

    public void calculateTotalCost(String[] productNames) {
        double totalCost = 0;
        for (String name : productNames) {
            for (Product p : inventory) {
                if (p.getName().equalsIgnoreCase(name)) {
                    totalCost += p.getPrice();
                    break;
                }
            }
        }
        System.out.println("Total cost: " + totalCost);
    }
}

public class JewelryShop {
    public static void main(String[] args) {
        JewelleryShop shop = new JewelleryShop();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to Jewellery Shop!");
            System.out.println("1. Add product");
            System.out.println("2. Remove product");
            System.out.println("3. Modify product");
            System.out.println("4. Display inventory");
            System.out.println("5. Calculate total cost");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = 0;
            while (true) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Invalid choice. Please enter a valid number: ");
                }
            }
            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    double price = 0;
                    while (true) {
                        try {
                            price = Double.parseDouble(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.print("Invalid price. Please enter a valid number: ");
                        }
                    }
                    System.out.print("Enter product description: ");
                    String desc = scanner.nextLine();
                    Product product = new Product(name, price, desc);
                    shop.addProduct(product);
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String removeName = scanner.nextLine();
                    shop.removeProduct(removeName);
                    break;
                case 3:
                    System.out.print("Enter product name: ");
                    String modifyName = scanner.nextLine();
                    shop.modifyProduct(modifyName);
                    break;
                case 4:
                    shop.displayInventory();
                    break;
                case 5:
                    System.out.print("Enter product names (comma-separated): ");
                    String[] productNames = scanner.nextLine().split(",");
                    shop.calculateTotalCost(productNames);
                    break;
                case 6:
                    System.out.println("Thank you for visiting Jewellery Shop!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}