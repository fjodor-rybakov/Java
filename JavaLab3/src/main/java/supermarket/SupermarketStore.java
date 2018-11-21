package supermarket;

import product.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class SupermarketStore {
    private boolean isWork = false;
    private ArrayList<Product> dataProducts;
    private int revenue = 0;
    private ArrayList<String> workTime = new ArrayList<>(
            Arrays.asList("8,00,22,00", "8,00,22,00", "8,00,22,00", "8,00,22,00", "8,30,22,20", "10,00,20,00", "10,00,20,00")
    );

    public ArrayList<String> getWorkTime() {
        return this.workTime;
    }

    public void setWorkTime(int dayIndex, String newWorkTime) {
        this.workTime.set(dayIndex, newWorkTime);
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

    public void addDataProducts(Product product) {
        this.dataProducts.add(product);
    }

    public void updateDataProduct(int count, Product product) {
        int index = this.getIndexProduct(product);
        if (index == -1) {
            System.out.println("No such product");
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

    public void updateDataProduct(String nameProduct, int price, int count, boolean isAcceptAge, int index) {
        Product temp = new Product(nameProduct, price, count, isAcceptAge);
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
