public class Console {
    public void showAskForLetterMessage() {
        System.out.println("Write a letter: ");
    }

    public void showYouFailedMessage(int tokensLeft) {
        System.out.println("You failed :/ You have " + tokensLeft + " tokens left.");
    }

    public void show(char[] displayedWord) {
        for (int i = 0; i < displayedWord.length; i++) {
            System.out.printf(displayedWord[i] + " ");
        }
        System.out.println();
    }

    public void showGameResult(boolean playerWins) {
        if (playerWins) {
            System.out.println("Congratulations!! You won!!! :)");
        }
        else {
            System.out.println("You lost :( Play and try again!");
        }
    }

    public void showGameRules() {
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
}
