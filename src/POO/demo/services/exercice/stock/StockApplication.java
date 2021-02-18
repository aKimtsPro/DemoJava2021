package POO.demo.services.exercice.stock;

import POO.demo.services.exercice.stock.data_access.StockGeneratorService;
import POO.demo.services.exercice.stock.models.Order;
import POO.demo.services.exercice.stock.models.Product;

import java.util.*;

public class StockApplication {

    static List<Product> stock = new ArrayList<>(); // TODO : service
    static List<Order> orders = new ArrayList<>();  // TODO : service

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Init stock
        stock = StockGeneratorService.getInstance().getDataFromCSV(); // TODO : service

        // Init display
        initMainMenu(scanner);

    }

    private static void initMainMenu(Scanner scanner) {

        int choice = 0;

        System.out.println();
        System.out.println("------\tStock Manager\t------");
        System.out.println("\t1. Show all products");
        System.out.println("\t2. Search");
        System.out.println("\t3. New order");
        System.out.println("\t4. Show all order");
        System.out.println("\t5. Exit");

        try {
            choice = scanner.nextInt();
        } catch (Exception ignored) {
            scanner.nextLine();
            choice = -1;
        }

        switch (choice) {
            case 1:
                showStock(scanner);
                initMainMenu(scanner);
                break;
            case 2:
                searchStock(scanner);
                initMainMenu(scanner);
                break;
            case 3:
                initNewOrder(scanner);
                initMainMenu(scanner);
                break;
            case 4:
                showOrders(scanner);
                initMainMenu(scanner);
                break;
            case 5:
                //System.exit(0);
                break;
            default:
                System.out.println("- entrée invalide -");
                initMainMenu(scanner);
        }
    }

    private static void showStock(Scanner scanner) {

        int choice = 0;

        // CHOICE OF 25, 50 , 100 PRODUCTS TO SHOW / PAGE
        System.out.println("How many products per page would you show ? [ 25 , 50 , 100 ]");
        System.out.println("\t1. 25 - default");
        System.out.println("\t2. 50");
        System.out.println("\t3. 100");

        try {
            choice = scanner.nextInt();
        } catch (Exception ignored) {
            scanner.nextLine();
            choice = -1;
        }

        switch (choice) {
            case 1:
                showStockWithPagination(25, scanner);
                break;
            case 2:
                showStockWithPagination(50, scanner);
                break;
            case 3:
                showStockWithPagination(100, scanner);
                break;
            default:
                System.out.println("- choix invalide, choix par défaut appliqué: 25 -");
        }


    }

    private static void searchStock(Scanner scanner) {

        int choice;

        do {
            System.out.println();
            System.out.println("------\tStock Search\t------");
            System.out.println("\t1. By product name");
            System.out.println("\t2. By price range");
            System.out.println("\t3. By quantity");
            System.out.println("\t4. By productor");
            System.out.println("\t5. Back to main menu");

            try {
                choice = scanner.nextInt();
            } catch (Exception ignored) {
                scanner.nextLine();
                choice = -1;
            }

            switch (choice) {
                case 1:
                    searchByProductName(scanner);
                    break;
                case 2:
                    searchByRangePrice(scanner);
                    break;
                case 3:
                    searchByQuantity(scanner);
                    break;
                case 4:
                    searchByProductor(scanner);
                    break;
                case 5:
                    System.out.println("- retour au menu principal -");
                    break;
                default:
                    System.out.println("- entrée invalide -");

            }

        } while (choice != 5);

    }

    private static void searchByProductName(Scanner scanner) {

        String productToFind;

        System.out.print("------\tProduct name : ");
        productToFind = scanner.next();

        if (!productToFind.equals("")) {
            stock
                    .stream()
                    .filter(p -> p.getProduct().contains(productToFind))
                    .sorted(Comparator.comparingInt(p -> p.getProduct().charAt(0))) // TODO : ListService
                    .forEach(System.out::println);

        }

        showSearchActions(scanner);

    }

    private static int enterNumber(){

        try{
            String input = scanner.nextLine();
            int rslt = Integer.parseInt(input);
            return rslt;
        }
        catch (Exception e){
            System.out.println("- nombre invalide. -");
            return enterNumber();
        }

    }

    private static void searchByRangePrice(Scanner scanner) {

        int min = 0, max = 0;
        System.out.println();

        try {
            System.out.print("------\tMinimum price : ");
            min = enterNumber();
            System.out.print("------\tMaximum price : ");
            max = enterNumber();
        } catch (Exception ignored) {

        }

        int finalMin = min, finalMax = max;
        stock
                .stream()
                .filter(p -> p.getPrice() >= finalMin && p.getPrice() <= finalMax)
                .sorted(Comparator.comparingInt(Product::getQuantity)) // TODO : Metier
                .forEach(System.out::println);

        showSearchActions(scanner);
    }

    private static void searchByQuantity(Scanner scanner) {

        int quantity = 0;
        System.out.println();

        try {
            System.out.print("------\tMaximum Quantity : ");
            quantity = scanner.nextInt();
        } catch (Exception ignored) {

        }

        int finalQuantity = quantity;
        stock
                .stream()
                .filter(p -> p.getQuantity() <= finalQuantity)
                .sorted(Comparator.comparingInt(p -> p.getProduct().charAt(0))) // TODO : metier
                .forEach(System.out::println);

        showSearchActions(scanner);
    }

    private static void searchByProductor(Scanner scanner) {
        String productorToFind;

        System.out.print("------\tProductor name : ");
        productorToFind = scanner.next();

        if (!productorToFind.equals("")) {
            stock
                    .stream()
                    .filter(p -> p.getProductor().contains(productorToFind))
                    .sorted(Comparator.comparingInt(p -> p.getProductor().charAt(0))) // TODO : metier
                    .forEach(System.out::println);

        }

        showSearchActions(scanner);
    }

    private static void showSearchActions(Scanner scanner) {

        int choice = 0;

        do {
            System.out.println();
            System.out.println("------\t1. Make an another search\t------");
            System.out.println("------\t2. Back to main menu\t------");

            try {
                choice = scanner.nextInt();
            } catch (Exception ignored) {
                scanner.nextLine();
                choice = -1;
            }

            switch (choice) {
                case 1:
                    searchStock(scanner);
                    break;
                case 2:
                    System.out.println("- retour au menu principal -");
                    break;
                default:
                    System.out.println("- choix invalide -");
            }

        } while (choice != 2);
    }

    private static void showStockWithPagination(int pagination, Scanner scanner) {

        int count = 0;
        int page = 1;
        String input = "";

        do {
            List<Product> temp = stock.subList(count, page * pagination); // TODO : mettre dans le metier

            input = scanner.nextLine();

            if (!input.equalsIgnoreCase("Q")) {
                temp.forEach(System.out::println);
                System.out.println();
                System.out.println("------\tPage " + page + "/" + stock.size() / pagination + "\t------");
                System.out.println("------\tPress Q to skip and return to main menu\t------");
            }

            count += pagination;
            page++;

        } while (count < 1000 && !input.equalsIgnoreCase("Q"));


    }

    private static void initNewOrder(Scanner scanner) {

        int id = orders.size() + 1;
        List<Product> productsToAdd = new ArrayList<>();
        int choice = 0, productID = -1;
        Order order;
        System.out.println();
        System.out.println("------\tNEW ORDER\t------");
        System.out.println("------\tProducts selection\t------");

        do {
            System.out.print("Product ID : ");
            productID = scanner.nextInt();
            int finalProductID = productID;

            Product product = stock
                    .stream()
                    .filter(p -> p.getId() == finalProductID)
                    .findFirst().orElseThrow(() -> new NoSuchElementException("Product with ID : " + id + " not found !!!")); // TODO : metier

            Product productToAdd = new Product(
                    product.getId(),
                    product.getProduct(),
                    product.getPrice(),
                    product.getQuantity(),
                    product.getProductor(),
                    product.getEmail()
            );

            System.out.println("Available Quantity for " + product.getProduct()+ " (" + product.getPrice() + " EUR) : " + product.getQuantity());
            int quantity = -1;
            do {
                System.out.print("Quantity for the product : ");
                quantity = scanner.nextInt();
                productToAdd.setQuantity(quantity);
                System.out.println("Price : " + productToAdd.getPrice() * quantity + " EUR");
            } while(quantity > product.getQuantity());

            System.out.println();
            System.out.println("------\tAdd another product to order\t------");
            System.out.println("------\t1. YES\t------");
            System.out.println("------\t2. NO\t------");
            try {
                choice = scanner.nextInt();
            }catch (Exception ignored) {
                scanner.nextLine();
                System.out.println("- choix invalide, retour au menu principal - ");
                choice = 2;
            }

            productsToAdd.add(productToAdd);

        } while (choice != 2);

        order = new Order(id);
        productsToAdd.forEach(order::addProduct);
        order.setPrice(order.calculateTotalPrice().isPresent() ? order.calculateTotalPrice().get() : null);
        System.out.println();
        System.out.println(order);
        orders.add(order); // TODO : metier

        updateStock(productsToAdd);

        initMainMenu(scanner);
    }

    private static void updateStock(List<Product> productsToAdd) { // TODO : metier
        productsToAdd.forEach(p -> {
            Product productToUpdate = stock
                    .stream()
                    .filter(product -> product.getId() == p.getId())
                    .findFirst()
                    .orElseThrow(() -> new NoSuchElementException("Product with ID : " + p.getId() + " not found !!!"));
            productToUpdate.setQuantity(productToUpdate.getQuantity() - p.getQuantity());
        });
    }

    private static void showOrders(Scanner scanner) {

        String choice = "";

        System.out.println("------\tALL ORDERS\t------");
        orders.forEach(System.out::println);

        System.out.println("------\tSTATISTICS\t------");
        System.out.println("Total orders : " + orders.size());
        System.out.println("Total prices : " + orders.stream().map(Order::getPrice).reduce(Double::sum).orElse(0D) + " EUR"); // TODO : Metier
        System.out.println();

        do {
            System.out.println("------\tQ to exit\t------");
            choice = scanner.next();
        } while (!choice.equalsIgnoreCase("Q"));
    }
}
