import java.util.Scanner;

public class MainRefactor1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = new String[] {
            "umbrella",
            "chronometer",
            "helicopter",
            "television",
            "wardrobe",
            "butterfly",
            "holidays",
            "wednesday",
            "happyness",
            "discipline"
        };

        int tokens = 3;

        System.out.println("You have to guess the hidden word.");
        System.out.println("You will be asked for a letter at each turn.");
        System.out.println("If the hidden word contains the letter it will be shown.");
        System.out.println("If the hidden word does not contain the letter you will lose a token.");
        System.out.println("You start the game with 3 tokens.");
        System.out.println("If you guess all letters of the hidden word you win.");
        System.out.println("If you lose all tokens you lose.");
        System.out.println("Good luck! The game is starting...");
        System.out.println();

        int random = (int)Math.floor(Math.random() * (10 - 1 + 1) + 1);
        char[] hidden = words[random - 1].toCharArray();
        char[] displayed = new char[hidden.length];

        for (int i = 0; i < displayed.length; i++) {
            displayed[i] = '_';
        }

        for (int i = 0; i < displayed.length; i++) {
            System.out.printf(displayed[i] + " ");
        }
        System.out.println();

        boolean gameOver = false;
        boolean playerWins= false;

        while (!gameOver && !playerWins) {
            System.out.println("Write a letter: ");
            String line = scanner.next();
            char letter = line.charAt(0);

            boolean letterFound = false;
            for (int i = 0; i < hidden.length; i++) {
                if (hidden[i] == letter) {
                    displayed[i] = letter;
                    letterFound = true;
                }
            }

            if (!letterFound) {
                tokens = tokens - 1;
                System.out.println("You failed :/ You have " + tokens + " tokens left.");
            }

            for (int i = 0; i < displayed.length; i++) {
                System.out.printf(displayed[i] + " ");
            }
            System.out.println("");

            playerWins = true;
            for (int i = 0; i < displayed.length; i++) {
                if (displayed[i] == '_')  {
                    playerWins = false;
                }
            }

            if (tokens == 0) {
                gameOver = true;
            }
        }

        if (playerWins) {
            System.out.println("Congratulations!! You won!!! :)");
        }
        else {
            System.out.println("You lost :( Play and try again!");
        }
    }
}
