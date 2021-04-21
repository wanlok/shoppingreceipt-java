public class GameTest2 extends Game {
    public void start() {
        data.prepare();
        data.setTargetLocation(data.searchLocations("NY"));
        data.addProduct("book", 17.99, 1);
        data.addProduct("pencil", 2.99, 3);
        output();
    }

    public static void main(String[] args) {
        new GameTest2().start();
    }
}
