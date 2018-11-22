package payment_method;

import java.util.ArrayList;

public interface IPaymentMethod {
    ArrayList<String> getPaymentMethods();
    void setPaymentMethods(String methods);
    String getTypePayment(int indexType);
}
