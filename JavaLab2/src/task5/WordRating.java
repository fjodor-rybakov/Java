package task5;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class WordRating {
    public Map<String, Integer> getRatingWords() {
        try(FileReader reader = new FileReader("words.txt")) {
            return readFile(reader);
        }
        catch(Exception error) {
            System.out.println(error.getMessage());
            return null;
        }
    }

    public void printRating(Map<String, Integer> resultRating) {
        if (resultRating != null) {
            for (Map.Entry entry: resultRating.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                System.out.println(key + " " + value);
            }
        }
    }

    private Map<String, Integer> readFile(FileReader reader) throws Exception {
        Map<String, Integer> result = new HashMap<>();
        String line = "";
        int counter = 1, value;

        while((value = reader.read()) != -1) {
            if (((char) value == ' ')) {
                if (result.containsKey(line)) {
                    result.put(line, result.get(line) + 1);
                } else {
                    result.put(line, counter);
                }

                line = "";
            } else {
                line += (char) value;
            }
        }

        return result;
    }
}
