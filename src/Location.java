public class Location {
    private String name;
    private String alias;
    private double salesTaxRate;
    private Category[] exemption;

    public Location(String name, String alias, double salesTaxRate, Category[] exemption) {
        this.name = name;
        this.alias = alias;
        this.salesTaxRate = salesTaxRate;
        this.exemption = exemption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public double getSalesTaxRate() {
        return salesTaxRate;
    }

    public void setSalesTaxRate(double salesTaxRate) {
        this.salesTaxRate = salesTaxRate;
    }

    public Category[] getExemption() {
        return exemption;
    }

    public void setExemption(Category[] exemption) {
        this.exemption = exemption;
    }
}
