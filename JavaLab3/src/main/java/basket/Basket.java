package basket;

import product.Product;
import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> basket = new ArrayList<>();

    public ArrayList<Product> getBasket() {
        return this.basket;
    }

    public void setBasket(ArrayList<Product> basket) {
        this.basket = basket;
    }

    public void addBasket(Product product) {
        this.basket.add(product);
    }
}
