package basket;

import product.Product;

import java.util.ArrayList;

public interface IBasket {
    ArrayList<Product> getBasket();
    void setBasket(ArrayList<Product> basket);
    void addBasket(Product product);
}
