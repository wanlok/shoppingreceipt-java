import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    public String getString(String label) {
        System.out.println(label);
        return scanner.nextLine();
    }

    public int getInteger(String label) {
        Integer value = null;
        while(value == null) {
            System.out.println(label);
            String temp = scanner.nextLine();
            try {
                value = Integer.parseInt(temp);
            } catch (NumberFormatException e) {

            }
        }
        return value;
    }

    public double getDouble(String label) {
        Double value = null;
        while(value == null) {
            System.out.println(label);
            String temp = scanner.nextLine();
            try {
                value = Double.parseDouble(temp);
            } catch (NumberFormatException e) {

            }
        }
        return value;
    }
}
