public class Main {
    public static void main(String[] args) {
        try {
            NetworkAddressDetermination networkAddressDetermination = new NetworkAddressDetermination();
            String resultAddress = networkAddressDetermination.getNetAddress(args[0], args[1]);
            System.out.println(resultAddress);
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }
}
