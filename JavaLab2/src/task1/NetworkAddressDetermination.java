package task1;

public class NetworkAddressDetermination {
    public String getNetAddress(String ip, String mask) {
        try {
            int[] ipAddressBinary = getAddressBinary(ip);
            int[] maskAddressBinary = getAddressBinary(mask);
            int lengthAddress = ipAddressBinary.length;
            String[] result = new String[lengthAddress];

            for (int index = 0; index < lengthAddress; index++)
                result[index] = String.valueOf(ipAddressBinary[index] & maskAddressBinary[index]);

            return String.join(".", result);
        } catch (Exception error) {
            return error.getMessage();
        }
    }

    private int[] getAddressBinary(String value) throws Exception {
        String[] address = value.split("\\.");
        if (address.length != 4)
            throw new Exception("Incorrect length address");

        int[] result = new int[address.length];

        for (int index = 0; index < address.length; index++)
            result[index] = Integer.parseInt(address[index]);

        return result;
    }

}
