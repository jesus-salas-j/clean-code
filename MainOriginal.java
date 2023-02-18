import java.util.Scanner;

// Game: guess the hidden word
public class MainOriginal {
    public static void main(String[] args) {
        // Object to read letters from keyboard
        Scanner scanner =new Scanner(System.in);

        // Hidden words array
        String[] w = new String[] {
                "umbrella",
                "chronometer",
                "helicopter",
                "television",
                "wardrobe",
                "butterfly",
                "holidays",
                "wednesday",
                "happyness",
                "discipline"}  ;
        // Player tokens
        int tks = 3;

        System.out.println("You have to guess the hidden word.");
        System.out.println("You will be asked for a letter at each turn.");
        System.out.println("If the hidden word contains the letter it will be shown.");
        System.out.println("If the hidden word does not contain the letter you will lose a token.");
        System.out.println("You start the game with 3 tokens.");
        System.out.println("If you guess all letters of the hidden word you win.");
        System.out.println("If you lose all tokens you lose.");
        System.out.println("Good luck! The game is starting...");
        System.out.println();

        // Generates random number between 1 and 10
        int random=(int)Math.floor(Math.random()*(10-1+1)+1) ;
        // Hidden word
        char[] hidden = w[random-1].toCharArray();
        // Create an array with same length of hidden word and fill it with "_" characters
        char[] displayed= new char[hidden.length];
        for (int i=0;i<displayed.length;i++) {
            displayed[i]='_';
        }

        // Print hidden word
        for (int i=0;i<displayed.length;i++) {
            System.out.printf(displayed[i]+" ");
        }
        System.out.println();

        // Indicates if game is over
        boolean gOver = false;

        // Indicates if you win
        boolean yWin= false;

        // Ask player for a new letter until he wins or loses all tokens
        while ( !gOver && !yWin){
            // A new letter is requested to the player
            System.out.println("Write a letter: ") ;
            String line = scanner.next();
            // Get the first char of the introduced string from keyboard
            char letter = line.charAt(0);
            boolean letterFound = false;
            for(int i=0;i<hidden.length;i++){
                if (hidden[i]==letter){
                    displayed[i]=letter; letterFound = true;
                }
            }
            if (!letterFound) { tks=tks-1;
                System.out.println("You failed :/ You have "+tks + " tokens left.");
            }

            for (int i=0;i<displayed.length;i++) {
                System.out.printf(displayed[i]+" ");
            }
            System.out.println("");

            yWin=true;
            for (int i=0;i<displayed.length;i++) {
                if  (displayed[i]=='_')  {
                    yWin=false;
                }
            }
            if(tks==0) {gOver=true; }
        }

        if (yWin) { System.out.println("Congratulations!! You won!!! :)");}
        else {
            System.out.println("You lost :( Play and try again!"); }
    }
}


