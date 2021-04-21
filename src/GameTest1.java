public class GameTest1 extends Game {
    public void start() {
        data.prepare();
        data.setTargetLocation(data.searchLocations("CA"));
        data.addProduct("book", 17.99, 1);
        data.addProduct("potato chips", 3.99, 1);
        output();
    }

    public static void main(String[] args) {
        new GameTest1().start();
    }
}
