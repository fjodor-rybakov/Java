package basket;

import product.Product;

import java.util.ArrayList;

public interface IBasket {
    ArrayList<Product> getBasket();
    void addBasket(Product product);
}
