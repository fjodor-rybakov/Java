package supermarket;

import product.Product;

import java.util.ArrayList;

public interface ISupermarketStore {
    ArrayList<String> getWorkTime();

    void setRevenue(int revenue);
    int getRevenue();

    ArrayList<Product> getDataProducts();
    void setDataProducts(ArrayList<Product> dataProducts);
    boolean isSetDataProducts();
    void updateDataProduct(int count, Product product);
    void updateDataProduct(int count, int index);
}
