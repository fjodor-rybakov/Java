import java.io.FileReader;
import java.util.Map;
import java.util.LinkedHashMap;

public class WordRating {
    private int countWords = 0;

    public Map<String, Integer> getRatingWords(String nameFile, int countWords) {
        try (FileReader reader = new FileReader(nameFile)) {
            this.countWords = countWords;
            return readFile(reader);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

    public void printRating(Map<String, Integer> resultRating) {
        if (resultRating != null) {
            int counter = 0;
            for (Map.Entry entry : resultRating.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                System.out.println(key + " " + value);
                counter++;
                if (counter == this.countWords) {
                    break;
                }
            }
        }
    }

    private Map<String, Integer> readFile(FileReader reader) throws Exception {
        Map<String, Integer> result = new LinkedHashMap<>();
        String line = "";
        int counter = 1, value;

        do {
            value = reader.read();
            if (((char) value == ' ' || value == -1)) {
                if (result.containsKey(line)) {
                    result.put(line, result.get(line) + 1);
                } else {
                    result.put(line, counter);
                }

                line = "";
            } else {
                line += (char) value;
            }
        } while (value != -1);

        return result;
    }
}
