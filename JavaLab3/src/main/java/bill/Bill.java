package bill;

import product.Product;
import java.util.ArrayList;

public class Bill {
    private ArrayList<Product> bill = new ArrayList<Product>();

    public ArrayList<Product> getBill() {
        return bill;
    }

    public void setBill(ArrayList<Product> bill) {
        this.bill = bill;
    }
}
