public class Product {
    private String name;
    private double price;
    private int quantity;
    private Category category;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        category = classify();
    }

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private Category classify() { // Best effort as not mentioned
        Category category = null;
        if (name != null) {
            if (name.contains("potato") || name.contains("apple")) {
                category = Category.FOOD;
            } else if (name.contains("cloths") || name.contains("pants") || name.contains("shirt")) {
                category = Category.CLOTHING;
            }
        }
        return category;
    }
}
