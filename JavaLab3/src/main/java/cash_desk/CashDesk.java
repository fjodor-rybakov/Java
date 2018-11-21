package cash_desk;

import customer.Customer;
import javafx.util.Pair;
import product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CashDesk {
    private Queue<Pair<Customer, Integer>> customerQueue = new ConcurrentLinkedQueue<>();

    public Queue<Pair<Customer, Integer>> getAllCustomerQueue() {
        return this.customerQueue;
    }

    public Pair<Customer, Integer> getCustomerQueue() {
        return this.customerQueue.peek();
    }

    public void addCustomerQueue(Customer customer, int time) {
        this.customerQueue.offer(new Pair<>(customer, time));
    }

    public Pair<Customer, Integer> removeCustomerQueue() {
        return this.customerQueue.poll();
    }

    public ArrayList<Product> filterProduct(Customer currentCustomer) {
        Product currentProduct;
        ArrayList<Product> dataProduct = new ArrayList<>();
        for (Iterator<Product> it = currentCustomer.getBasket().iterator(); it.hasNext();) {
            currentProduct = it.next();
            if (!currentProduct.isAcceptAge() && currentCustomer.getCustomerCategory().equals("Child")) {
                dataProduct.add(currentProduct);
                System.out.println("This product not accept for your category: " + currentProduct.getNameProduct());
                it.remove();
            }
        }
        return dataProduct;
    }
}
