package task2;

import java.util.ArrayList;

public class CaesarCipher {
    private ArrayList<Integer> positionUpperLetter = new ArrayList<>();

    public String cipher(String typeWork, int key, String cipherLine) {
        switch (typeWork) {
            case "-e":
                return encoding(key, cipherLine);
            case "-d":
                return encoding(-key, cipherLine);
            default:
                return "type work is empty";
        }
    }

    private String encoding(int key, String cipherLine) {
        int shift, currentPos;
        StringBuilder result = new StringBuilder();

        for (int index = 0; index < cipherLine.length(); index++) {
            currentPos = cipherLine.charAt(index);

            if (Character.isUpperCase(((char) currentPos))) {
                positionUpperLetter.add(index);
                currentPos = Character.toLowerCase(currentPos);
            }

            shift = setCorrectIndex(currentPos, key);
            result.append((char) shift);
        }

        return restoreLine(result.toString());
    }

    private String restoreLine(String cipherLine) {
        StringBuilder result = new StringBuilder(cipherLine);

        for (Integer aPositionUpperLetter : this.positionUpperLetter)
            result.setCharAt(aPositionUpperLetter, Character.toUpperCase(cipherLine.charAt(aPositionUpperLetter)));

        return result.toString();
    }

    private int setCorrectIndex(int oldPos, int key) {
        int newPos = oldPos + key;

        if (newPos > 122)
            return oldPos + (key % 26);
        if (newPos < 97)
            return oldPos - (key % 26);

        return newPos;
    }
}
