import customer.Customer;
import customer.GenerateCustomer;
import product.GenerateProduct;
import product.Product;
import supermarket.Supermarket;
import java.util.ArrayList;

public class SupermarketSimulator {
    private static Supermarket supermarket = new Supermarket();

    public static void main(String[] args) {
        GenerateProduct generateProduct = new GenerateProduct(150, 1000);
        ArrayList<Product> allProducts = generateProduct.randomGenerateProduct(30);
        supermarket.setDataProducts(allProducts);

        supermarket.start(5);
    }
}
