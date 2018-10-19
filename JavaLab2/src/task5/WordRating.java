package task5;

import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class WordRating {
    public void getRatingWords() {
        try(FileReader reader = new FileReader("words.txt")) {
            int value;
            String line = "";
            Map<String, Integer> result = new HashMap<>();
            int counter = 0;

            while((value = reader.read()) != -1) {
                if (((char) value == ' ')) {
                    if (!result.containsKey(line)) {
                        System.out.println(line);
                    }
                    result.put(line, counter);
                } else {
                    line += (char) value;
                }
            }
        }
        catch(Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
