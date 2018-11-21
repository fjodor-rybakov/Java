package payment_method;

import java.util.ArrayList;
import java.util.Arrays;

public class PaymentMethod {
    private ArrayList<String> paymentMethods = new ArrayList<String>(
            Arrays.asList("card", "cash", "bonus")
    );

    public ArrayList<String> getPaymentMethods() {
        return paymentMethods;
    }

    public void setPaymentMethods(String methods) {
        this.paymentMethods.add(methods);
    }

    public String getTypePayment(int indexType) {
        return this.paymentMethods.get(indexType);
    }
}
