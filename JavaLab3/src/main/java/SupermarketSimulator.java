import customer.Customer;
import customer.GenerateCustomer;
import product.GenerateProduct;
import product.Product;
import supermarket.Supermarket;
import java.util.ArrayList;

public class SupermarketSimulator {
    public static void main(String[] args) {
        Supermarket supermarket = new Supermarket();

        GenerateProduct generateProduct = new GenerateProduct(150, 1000);
        ArrayList<Product> allProducts = generateProduct.randomGenerateProducts(30);
        supermarket.setDataProducts(allProducts);

        supermarket.setWork(true);

        GenerateCustomer generateCustomer = new GenerateCustomer(100, 10000);
        ArrayList<Customer> allCustomers = generateCustomer.randomGenerateCustomer(10);

        

        supermarket.setWork(false);
    }
}
