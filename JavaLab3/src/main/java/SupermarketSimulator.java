import customer.Customer;
import customer.GenerateCustomer;
import product.Product;
import supermarket.Supermarket;
import java.util.ArrayList;

public class SupermarketSimulator {
    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();

        Product apple = new Product("Apple", 20, 35);
        Product orange = new Product("Orange", 30, 5);
        Product water = new Product("Water", 20, 45);
        Product juice = new Product("Juice", 15, 40);
        Product potato = new Product("Potato", 10, 300);
        Product garnet = new Product("Garnet", 80, 2);

        supermarket.setDataProducts(apple);
        supermarket.setDataProducts(orange);
        supermarket.setDataProducts(water);
        supermarket.setDataProducts(juice);
        supermarket.setDataProducts(potato);
        supermarket.setDataProducts(garnet);

        supermarket.setWork(true);

        GenerateCustomer generateCustomer = new GenerateCustomer(100, 10000);
        ArrayList<Customer> allCustomers = generateCustomer.randomGenerateCustomer(10);


        supermarket.setWork(false);
    }
}
