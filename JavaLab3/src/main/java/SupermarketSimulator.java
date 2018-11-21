import product.GenerateProduct;
import product.Product;
import supermarket.Supermarket;

import java.util.ArrayList;

public class SupermarketSimulator {
    private static Supermarket supermarket = new Supermarket();

    public static void main(String[] args) {
        System.out.println("[time 0] Supermarket products have been formed: ");
        GenerateProduct generateProduct = new GenerateProduct(150, 1000);
        ArrayList<Product> allProducts = generateProduct.randomGenerateProduct(30);
        supermarket.setDataProducts(allProducts);
        for (Product product : allProducts) {
            System.out.println(
                "[" + product.getNameProduct() +
                ", price: " + product.getPrice() +
                ", count: " + product.getCount() +
                ", isAcceptAge: " + product.isAcceptAge() + "]"
            );
        }

        supermarket.start(5);
    }
}
