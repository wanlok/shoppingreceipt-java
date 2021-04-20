import java.util.ArrayList;
import java.util.List;

public class Data {

    private List<Location> locations;

    private Location targetLocation;

    private List<Product> products;

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }

    public Location getTargetLocation() {
        return targetLocation;
    }

    public void setTargetLocation(Location targetLocation) {
        this.targetLocation = targetLocation;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(String productName, double price, int quantity) {
        if (products != null) {
            products.add(new Product(productName, price, quantity));
        }
    }

    public double computeSubtotal() {
        double subtotal = 0;
        for (Product product: products) {
            subtotal += product.getPrice() * product.getQuantity();
        }
        return subtotal;
    }

    public double computeTax() {
        double tax = 0;
        if (targetLocation != null) {
            for (Product product: products) {
                boolean skip = false;
                for (Category category: targetLocation.getExemption()) {
                    if (product.getCategory() == category) {
                        skip = true;
                        break;
                    }
                }
                if (!skip) {
                    tax += product.getPrice() * product.getQuantity() * targetLocation.getSalesTaxRate();
                }
            }
        }
        return Math.ceil(tax * 20.0) / 20.0; // round up to nearest 0.05
    }

    public void prepare() {
        List<Location> locations = new ArrayList();
        locations.add(new Location("California", "CA", 0.0975, new Category[] { Category.FOOD }));
        locations.add(new Location("New York", "NY", 0.08875, new Category[] { Category.FOOD, Category.CLOTHING }));
        this.locations = locations;
        targetLocation = null;
        products = new ArrayList<>();
    }

    public Location searchLocations(String key) {
        Location target = null;
        for (Location location: locations) {
            if (location.getAlias().equals(key)) {
                target = location;
                break;
            }
        }
        return target;
    }
}
