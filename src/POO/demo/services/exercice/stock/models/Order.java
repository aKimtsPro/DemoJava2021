package POO.demo.services.exercice.stock.models;

import java.util.*;
import java.time.LocalDateTime;

public class Order {

    private int id;
    private String name;
    private LocalDateTime dateTime;
    private List<Product> products = new ArrayList<>();
    private Double price;

    public Order(int id) {
        this.id = id;
        this.name = "Order#" + id;
        this.dateTime = LocalDateTime.now();
        this.price = calculateTotalPrice().isPresent() ? calculateTotalPrice().get() : null;
    }

    // GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Double getPrice() {
        return price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(Product p) {
        this.products.add(p);
    }

    public Optional<Double> calculateTotalPrice() {
        return products
                .stream()
                .map(p -> p.getPrice() * p.getQuantity())
                .reduce(Double::sum);
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", dateTime=").append(dateTime);
        sb.append(", total price=").append(price);
        sb.append(", products=").append(products);
        sb.append('}');
        return sb.toString();
    }
}
