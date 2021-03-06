package supermarket;

import product.Product;
import utils.Logger;

import java.util.ArrayList;
import java.util.Arrays;

public class SupermarketStore implements ISupermarketStore {
    private boolean isWork = false;
    private Logger logger = new Logger(true);
    private ArrayList<Product> dataProducts;
    private int revenue = 0;
    private ArrayList<String> workTime = new ArrayList<>(
            Arrays.asList("8,00,22,00", "8,00,22,00", "8,00,22,00", "8,00,22,00", "8,30,22,20", "10,00,20,00", "10,00,20,00")
    );

    public ArrayList<String> getWorkTime() {
        return this.workTime;
    }

    protected boolean isWork() {
        return isWork;
    }

    protected void setWork(boolean work) {
        isWork = work;
    }


    public int getRevenue() {
        return this.revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }

    public ArrayList<Product> getDataProducts() {
        return this.dataProducts;
    }

    public void setDataProducts(ArrayList<Product> dataProducts) {
        this.dataProducts = dataProducts;
    }

    public boolean isSetDataProducts() {
        return this.dataProducts.size() != 0;
    }

    public void updateDataProduct(int count, Product product) {
        int index = this.getIndexProduct(product);
        if (index == -1) {
            logger.printLog("No such product");
            return;
        }
        this.updateDataProduct(count, index);
    }

    public void updateDataProduct(int count, int index) {
        String name = this.dataProducts.get(index).getNameProduct();
        int price = this.dataProducts.get(index).getPrice();
        boolean isAcceptAge = this.dataProducts.get(index).isAcceptAge();
        Product temp = new Product(name, price, count, isAcceptAge);
        this.dataProducts.set(index, temp);
    }

    private int getIndexProduct(Product product) {
        for (int i = 0; i < dataProducts.size(); i++) {
            if (dataProducts.get(i) == product) {
                return i;
            }
        }
        return -1;
    }
}
