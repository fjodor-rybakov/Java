package customer;

import payment_method.PaymentMethod;

public interface ICustomer {
    String getName();
    String getCustomerCategory();
    int getAge();
    int getCountMoney();
    PaymentMethod getPaymentMethods();
}
