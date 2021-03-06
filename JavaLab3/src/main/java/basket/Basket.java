package basket;

import product.Product;
import java.util.ArrayList;

public class Basket implements IBasket {
    private ArrayList<Product> basket = new ArrayList<>();

    public ArrayList<Product> getBasket() {
        return this.basket;
    }

    public void addBasket(Product product) {
        this.basket.add(product);
    }
}
