import org.junit.jupiter.api.Test;
import product.GenerateProduct;
import product.Product;
import supermarket.Supermarket;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSupermarketSimulator {
    private Supermarket supermarket = new Supermarket();
    private GenerateProduct generateProduct = new GenerateProduct(150, 1000);
    private ArrayList<Product> allProducts = generateProduct.randomGenerateProduct(30);

    @Test
    public void checkSetProductSupermarket() {
        supermarket.setDataProducts(allProducts);
        assertEquals(supermarket.getDataProducts().size() > 0, supermarket.isSetDataProducts());
    }
}
