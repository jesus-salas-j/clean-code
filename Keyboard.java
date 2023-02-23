import java.util.Scanner;

public class Keyboard {
    private final Scanner scanner;
    public Keyboard() {
        scanner = new Scanner(System.in);
    }

    public char askForLetter() {
        String line = scanner.next();
        return line.charAt(0);
    }
}
