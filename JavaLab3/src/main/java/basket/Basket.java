package basket;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<String, Integer> basket = new HashMap<String, Integer>();

    public Map<String, Integer> getBasket() {
        return this.basket;
    }

    public void setBasket(String nameProduct, int countProduct) {
        this.basket.put(nameProduct, countProduct);
    }
}
