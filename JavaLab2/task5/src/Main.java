public class Main {
    public static void main(String[] args) {
        try {
            WordRating wordRating = new WordRating();
            wordRating.printRating(wordRating.getRatingWords(args[0], Integer.parseInt(args[1])));
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
