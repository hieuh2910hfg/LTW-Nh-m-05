package model;

public class Product {
    private int id;
    private String description;
    private double price;
    private String productLinks; // Trường mới

    // Constructor
    public Product(int id, String description, double price, String productLinks) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.productLinks = productLinks; // Gán giá trị
    }
    // Constructor không có categoryId
    public Product(String description, double price, String productLinks) {
        this.description = description;
        this.price = price;
        this.productLinks = productLinks;
    }


    // Getters
    public int getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public String getProductLinks() { // Getter mới
        return productLinks;
    }
}
