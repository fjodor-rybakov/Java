public class Main {
    public static void main(String[] args) {
        try {
            TypeTable typeTable = new TypeTable();
            typeTable.getTypes();
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
