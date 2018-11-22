package cash_desk;

import customer.Customer;
import javafx.util.Pair;
import product.Product;

import java.util.ArrayList;
import java.util.Queue;

public interface ICashDesk {
    Queue<Pair<Customer, Integer>> getAllCustomerQueue();
    Pair<Customer, Integer> getCustomerQueue();
    void addCustomerQueue(Customer customer, int time);
    Pair<Customer, Integer> removeCustomerQueue();
    ArrayList<Product> filterProduct(Customer currentCustomer);
}
