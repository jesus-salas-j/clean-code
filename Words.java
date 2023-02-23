public class Words {
    public static final int MAX_WORDS_INDEX = 10;
    public static final int MIN_WORDS_INDEX = 1;
    private final String[] words;

    public Words() {
        words = new String[]{
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

    public char[] randomWord() {
        int randomIndex = generateRandomIndex();
        return words[randomIndex - 1].toCharArray();
    }

    private int generateRandomIndex() {
        return (int) Math.floor(Math.random() * (MAX_WORDS_INDEX - MIN_WORDS_INDEX + 1) + MIN_WORDS_INDEX);
    }
}
