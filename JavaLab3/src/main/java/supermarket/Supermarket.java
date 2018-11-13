package supermarket;

import product.Product;
import java.util.ArrayList;
import java.util.Arrays;

public class Supermarket {
    private boolean isWork = false;
    private ArrayList<Product> dataProducts = new ArrayList<Product>();
    private ArrayList<String> workTime = new ArrayList<String>(
            Arrays.asList("8,22", "8,22", "8,22", "8,22", "8,22", "10,20", "10,20")
    );

    public ArrayList<String> getWorkTime() {
        return this.workTime;
    }

    public void setWorkTime(int dayIndex, String newWorkTime) {
        this.workTime.set(dayIndex, newWorkTime);
    }

    public boolean isWork() {
        return isWork;
    }

    public void setWork(boolean work) {
        isWork = work;
    }

    public ArrayList<Product> getDataProducts() {
        return this.dataProducts;
    }

    public void addDataProducts(Product product) {
        this.dataProducts.add(product);
    }

    public void setDataProducts(ArrayList<Product> dataProducts) {
        this.dataProducts = dataProducts;
    }
}
