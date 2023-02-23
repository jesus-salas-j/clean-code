public class Game {
    public static final int NONE = 0;
    public static final char HIDDEN_CHARACTER = '_';
    public static final int INITIAL_TOKENS = 3;

    private final Console console;
    private final Keyboard keyboard;
    private final Words words;

    public Game(Console console, Keyboard keyboard, Words words) {
        this.console = console;
        this.keyboard = keyboard;
        this.words = words;
    }

    public void run() {
        int tokens = INITIAL_TOKENS;
        boolean gameOver = false;
        boolean playerWins= false;

        console.showGameRules();
        char[] hiddenWord = words.randomWord();
        char[] displayedWord = initializeDisplayedWordFrom(hiddenWord.length);
        console.show(displayedWord);

        while (gameHasNotFinished(gameOver, playerWins)) {
            char letter = askForLetter();

            if (isLetterFoundIn(hiddenWord, letter)) {
                displayedWord = updateDisplayedWordWith(hiddenWord, letter, displayedWord);
            } else {
                tokens = decrementTokens(tokens);
            }

            console.show(displayedWord);
            playerWins = playerHasAlreadyWon(displayedWord);
            gameOver = playerHasNotMoreTokensLeft(tokens);
        }

        console.showGameResult(playerWins);
    }

    private char askForLetter() {
        console.showAskForLetterMessage();
        return keyboard.askForLetter();
    }

    private char[] updateDisplayedWordWith(char[] hiddenWord, char letter, char[] displayedWord) {
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

    private boolean playerHasNotMoreTokensLeft(int tokens) {
        return tokens == NONE;
    }

    private boolean playerHasAlreadyWon(char[] displayedWord) {
        boolean playerWins = true;

        for (int i = 0; i < displayedWord.length; i++) {
            if (displayedWord[i] == HIDDEN_CHARACTER)  {
                playerWins = false;
            }
        }

        return playerWins;
    }

    private int decrementTokens(int tokens) {
        int tokensLeft = tokens - 1;
        console.showYouFailedMessage(tokensLeft);
        return tokensLeft;
    }

    private boolean isLetterFoundIn(char[] hiddenWord, char letter) {
        boolean letterFound = false;

        for (int i = 0; i < hiddenWord.length; i++) {
            if (hiddenWord[i] == letter) {
                letterFound = true;
            }
        }

        return letterFound;
    }

    private boolean gameHasNotFinished(boolean gameOver, boolean playerWins) {
        return !gameOver && !playerWins;
    }

    private char[] initializeDisplayedWordFrom(int wordLength) {
        char[] displayedWord = new char[wordLength];

        for (int i = 0; i < displayedWord.length; i++) {
            displayedWord[i] = HIDDEN_CHARACTER;
        }

        return displayedWord;
    }
}
