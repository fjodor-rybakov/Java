import customer.Customer;
import customer.GenerateCustomer;
import product.GenerateProduct;
import product.Product;
import supermarket.Supermarket;
import java.util.ArrayList;
import java.util.Random;

public class SupermarketSimulator {
    private static Supermarket supermarket = new Supermarket();
    private static Random random = new Random();

    public static void main(String[] args) {

        GenerateProduct generateProduct = new GenerateProduct(150, 1000);
        ArrayList<Product> allProducts = generateProduct.randomGenerateProduct(30);
        supermarket.setDataProducts(allProducts);

        GenerateCustomer generateCustomer = new GenerateCustomer(100, 10000);
        ArrayList<Customer> allCustomers = generateCustomer.randomGenerateCustomer(10);

        supermarket.start(5, allCustomers);
    }
}
