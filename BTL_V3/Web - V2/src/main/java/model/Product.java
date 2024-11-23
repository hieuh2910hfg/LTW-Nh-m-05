package model;

public class Product {
    private int id;
    private String description;
    private double price;

    // Constructor
    public Product(int id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    // Getters và Setters
    public int getId() { return id; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }

	public int getCategoryId() {
		// TODO Auto-generated method stub
		return 0;
	}
}