public class Main {
    public static void main(String[] args) {
        try {
            PasswordGenerator passwordGenerator = new PasswordGenerator();
            String resultPassword = passwordGenerator.generatePassword(Integer.parseInt(args[0]), args[1]);
            System.out.println(resultPassword);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
