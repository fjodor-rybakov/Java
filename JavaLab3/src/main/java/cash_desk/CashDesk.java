package cash_desk;

import customer.Customer;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CashDesk {
    private Queue<Customer> customerQueue = new ConcurrentLinkedQueue<Customer>();

    public Queue<Customer> getCustomerQueue() {
        return customerQueue;
    }

    public void addCustomerQueue(Customer customer) {
        this.customerQueue.offer(customer);
    }

    public void removeCustomerQueue() {
        this.customerQueue.remove();
    }
}
