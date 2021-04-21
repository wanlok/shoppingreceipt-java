public class GameTest3 extends Game {
    public void start() {
        data.prepare();
        data.setTargetLocation(data.searchLocations("NY"));
        data.addProduct("pencil", 2.99, 2);
        data.addProduct("shirt", 29.99, 1);
        output();
    }

    public static void main(String[] args) {
        new GameTest3().start();
    }
}
