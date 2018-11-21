package bill;

import customer.Customer;
import product.Product;

public class Bill {
    public static int getBill(Customer customer) {
        int result = 0;
        for (Product product : customer.getBasket()) {
            result += product.getCount() * product.getPrice();
        }
        return result;
    }
}
