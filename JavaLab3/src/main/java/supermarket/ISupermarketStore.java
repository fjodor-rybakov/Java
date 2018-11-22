package supermarket;

import product.Product;

import java.util.ArrayList;

public interface ISupermarketStore {
    ArrayList<String> getWorkTime();
    void setWorkTime(int dayIndex, String newWorkTime);

    void setRevenue(int revenue);
    int getRevenue();

    ArrayList<Product> getDataProducts();
    void setDataProducts(ArrayList<Product> dataProducts);
    void addDataProducts(Product product);
    boolean isSetDataProducts();
    void updateDataProduct(int count, Product product);
    void updateDataProduct(int count, int index);
    void updateDataProduct(String nameProduct, int price, int count, boolean isAcceptAge, int index);
}
