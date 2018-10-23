public class PasswordGenerator {
    public String generatePassword(int lengthPassword, String charOnPassword) {
        if (lengthPassword <= 0 || charOnPassword.isEmpty())
            return "The length should not be 0";

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < lengthPassword; i++)
            result.append(charOnPassword.charAt((int) (Math.random() * charOnPassword.length())));

        return result.toString();
    }
}
