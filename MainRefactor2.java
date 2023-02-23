import java.util.Scanner;

public class MainRefactor2 {

    public static final int MAX_WORDS_INDEX = 10;
    public static final int MIN_WORDS_INDEX = 1;
    public static final int NONE = 0;
    public static final char HIDDEN_CHARACTER = '_';
    public static final int INITIAL_TOKENS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tokens = INITIAL_TOKENS;
        boolean gameOver = false;
        boolean playerWins= false;

        showGameRules();
        char[] hiddenWord = chooseRandomWord();
        char[] displayedWord = initializeDisplayedWordFrom(hiddenWord.length);
        show(displayedWord);


        while (gameHasNotFinished(gameOver, playerWins)) {
            char letter = askForLetter(scanner);

            if (isLetterFoundIn(hiddenWord, letter)) {
                displayedWord = updateDisplayedWordWith(hiddenWord, letter, displayedWord);
            } else {
                tokens = decrementTokens(tokens);
            }

            show(displayedWord);
            playerWins = playerHasAlreadyWon(displayedWord);
            gameOver = playerHasNotMoreTokensLeft(tokens);
        }

        showGameResult(playerWins);
    }

    private static void showGameResult(boolean playerWins) {
        if (playerWins) {
            System.out.println("Congratulations!! You won!!! :)");
        }
        else {
            System.out.println("You lost :( Play and try again!");
        }
    }

    private static char[] updateDisplayedWordWith(char[] hiddenWord, char letter, char[] displayedWord) {
        char[] updatedDisplayedWord = new char[displayedWord.length];

        for (int i = 0; i < hiddenWord.length; i++) {
            if (hiddenWord[i] == letter) {
                updatedDisplayedWord[i] = letter;
            } else {
                updatedDisplayedWord[i] = displayedWord[i];
            }
        }

        return updatedDisplayedWord;
    }

    private static boolean playerHasNotMoreTokensLeft(int tokens) {
        return tokens == NONE;
    }

    private static boolean playerHasAlreadyWon(char[] displayedWord) {
        boolean playerWins = true;

        for (int i = 0; i < displayedWord.length; i++) {
            if (displayedWord[i] == HIDDEN_CHARACTER)  {
                playerWins = false;
            }
        }

        return playerWins;
    }

    private static int decrementTokens(int tokens) {
        int tokensLeft = tokens - 1;
        System.out.println("You failed :/ You have " + tokensLeft + " tokens left.");
        return tokensLeft;
    }

    private static boolean isLetterFoundIn(char[] hiddenWord, char letter) {
        boolean letterFound = false;

        for (int i = 0; i < hiddenWord.length; i++) {
            if (hiddenWord[i] == letter) {
                letterFound = true;
            }
        }

        return letterFound;
    }

    private static char askForLetter(Scanner scanner) {
        System.out.println("Write a letter: ");
        String line = scanner.next();
        char letter = line.charAt(0);
        return letter;
    }

    private static boolean gameHasNotFinished(boolean gameOver, boolean playerWins) {
        return !gameOver && !playerWins;
    }

    private static void show(char[] displayed) {
        for (int i = 0; i < displayed.length; i++) {
            System.out.printf(displayed[i] + " ");
        }
        System.out.println();
    }

    private static char[] initializeDisplayedWordFrom(int wordLength) {
        char[] displayedWord = new char[wordLength];

        for (int i = 0; i < displayedWord.length; i++) {
            displayedWord[i] = HIDDEN_CHARACTER;
        }

        return displayedWord;
    }

    private static char[] chooseRandomWord() {
        String[] words = initializeWords();
        int random = generateRandomIndex();
        return words[random - 1].toCharArray();
    }

    private static int generateRandomIndex() {
        return (int) Math.floor(Math.random() * (MAX_WORDS_INDEX - MIN_WORDS_INDEX + 1) + MIN_WORDS_INDEX);
    }

    private static void showGameRules() {
        System.out.println("You have to guess the hidden word.");
        System.out.println("You will be asked for a letter at each turn.");
        System.out.println("If the hidden word contains the letter it will be shown.");
        System.out.println("If the hidden word does not contain the letter you will lose a token.");
        System.out.println("You start the game with 3 tokens.");
        System.out.println("If you guess all letters of the hidden word you win.");
        System.out.println("If you lose all tokens you lose.");
        System.out.println("Good luck! The game is starting...");
        System.out.println();
    }

    private static String[] initializeWords() {
        return new String[]{
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
    }
}
