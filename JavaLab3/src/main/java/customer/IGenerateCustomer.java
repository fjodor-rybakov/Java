package customer;

import java.util.ArrayList;

public interface IGenerateCustomer {
    ArrayList<Customer> randomGenerateCustomer(int countCustomers);
    Customer randomGenerateCustomer();
}
