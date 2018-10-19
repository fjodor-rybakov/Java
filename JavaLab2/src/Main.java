import task1.NetworkAddressDetermination;
import task2.CaesarCipher;
import task3.PasswordGenerator;
import task4.TypeTable;
import task5.WordRating;

public class Main {
    public static void main(String[] args) {
        NetworkAddressDetermination networkAddressDetermination = new NetworkAddressDetermination();
        String resultAddress = networkAddressDetermination.getNetAddress("192.168.1.2", "255.255.254.0");
        System.out.println(resultAddress);

        CaesarCipher caesarCipher = new CaesarCipher();
        String resultLine = caesarCipher.cipher("-d", 1, "exxegoexsrgi");
        System.out.println(resultLine);

        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String resultPassword = passwordGenerator.generatePassword(87, "abdefg123456_");
        System.out.println(resultPassword);

        /*TypeTable typeTable = new TypeTable();
        typeTable.getTypes();*/

        WordRating wordRating = new WordRating();
        wordRating.getRatingWords();
    }
}
