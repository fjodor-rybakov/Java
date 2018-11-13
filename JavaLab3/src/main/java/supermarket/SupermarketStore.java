package supermarket;

import product.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class SupermarketStore {
    private boolean isWork = false;
    private ArrayList<Product> dataProducts = new ArrayList<Product>();
    private ArrayList<String> workTime = new ArrayList<String>(
            Arrays.asList("8:00,22:00", "8:00,22:00", "8:00,22:00", "8:00,22:00", "8:00,22:00", "10:00,20:00", "10:00,20:00")
    );

    public ArrayList<String> getWorkTime() {
        return this.workTime;
    }

    public void setWorkTime(int dayIndex, String newWorkTime) {
        this.workTime.set(dayIndex, newWorkTime);
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

    protected boolean isWork() {
        return isWork;
    }

    protected void setWork(boolean work) {
        isWork = work;
    }
}
