package payment_method;

import java.util.ArrayList;
import java.util.Arrays;

public class PaymentMethod implements IPaymentMethod {
    private ArrayList<String> paymentMethods = new ArrayList<String>(
            Arrays.asList("card", "cash", "bonus")
    );

    public String getTypePayment(int indexType) {
        return this.paymentMethods.get(indexType);
    }
}
