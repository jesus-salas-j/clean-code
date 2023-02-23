public class MainRefactor3 {
    public static void main(String[] args) {
        Console console = new Console();
        Keyboard keyboard = new Keyboard();
        Words words = new Words();
        Game game = new Game(console, keyboard, words);
        game.run();
    }
}
