public class Main {
    public static void main(String[] args) {
        try {
            CaesarCipher caesarCipher = new CaesarCipher();
            String resultLine = caesarCipher.cipher(args[0], Integer.parseInt(args[1]), args[2]);
            System.out.println(resultLine);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
