public class Game {

    private Data data = new Data();
    private Input input = new Input();

    private void input() {
        String s;

        do {
            String location = input.getString("Location:");
            data.setTargetLocation(data.searchLocations(location));
        } while (data.getTargetLocation() == null);

        do {
            String productName = input.getString("Product name:");
            double price = input.getDouble("Price:");
            int quantity = input.getInteger("Quantity:");
            data.addProduct(productName, price, quantity);

            s = input.getString("Continue? Y/N");
        } while ("Y".equals(s) || "y".equals(s));
    }

    private void output() {
        int aLength = 0;
        int bLength = 0;
        int cLength = 0;

        for (Product product: data.getProducts()) {
            int a = product.getName().length();
            if (a > aLength) {
                aLength = a;
            }
            int b = ("$" + String.format("%.2f", product.getPrice())).length();
            if (b > bLength) {
                bLength = b;
            }
            int c = ("" + product.getQuantity()).length();
            if (c > cLength) {
                cLength = c;
            }
        }

        String subtotalLabel = "subtotal:";
        String taxLabel = "tax:";
        String totalLabel = "total:";

        if (aLength < subtotalLabel.length()) {
            aLength = subtotalLabel.length();
        }
        if (aLength < totalLabel.length()) {
            aLength = totalLabel.length();
        }
        if (aLength < taxLabel.length()) {
            aLength = taxLabel.length();
        }
        if (cLength < 3) {
            cLength = 3;
        }

        String t = "        ";
        int dLength = t.length() + bLength + t.length() + cLength;

        System.out.println(String.format("%-" + aLength + "s", "item") + t + String.format("%" + bLength + "s", "price") + t + String.format("%" + cLength + "s", "qty"));
        System.out.println();
        for (Product product: data.getProducts()) {
            System.out.println(String.format("%-" + aLength + "s", product.getName()) + t + String.format("%" + bLength + "s", "$" + String.format("%.2f", product.getPrice())) + t + String.format("%" + cLength + "s", product.getQuantity()));
        }
        System.out.println(String.format("%-" + aLength + "s", subtotalLabel) + String.format("%" + dLength + "s", "$" + String.format("%.2f", data.computeSubtotal()))); // Can iterate in the above loop to boost performance
        System.out.println(String.format("%-" + aLength + "s", taxLabel) + String.format("%" + dLength + "s", "$" + String.format("%.2f", data.computeTax())));
        System.out.println(String.format("%-" + aLength + "s", totalLabel) + String.format("%" + dLength + "s", "$" + String.format("%.2f", data.computeSubtotal() + data.computeTax())));
    }

    public void start() {
        data.prepare();
        input();
        output();
    }

    public void testcase1() {
        data.prepare();
        data.setTargetLocation(data.searchLocations("CA"));
        data.addProduct("book", 17.99, 1);
        data.addProduct("potato chips", 3.99, 1);
        output();
    }

    public void testcase2() {
        data.prepare();
        data.setTargetLocation(data.searchLocations("NY"));
        data.addProduct("book", 17.99, 1);
        data.addProduct("pencil", 2.99, 3);
        output();
    }

    public void testcase3() {
        data.prepare();
        data.setTargetLocation(data.searchLocations("NY"));
        data.addProduct("pencil", 2.99, 2);
        data.addProduct("shirt", 29.99, 1);
        output();
    }
}
