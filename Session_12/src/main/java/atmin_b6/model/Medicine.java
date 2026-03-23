package atmin_b6.model;

public class Medicine {
    private int id;
    private String name;
    private double price;
    private int stock;

    public Medicine(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getter
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
}