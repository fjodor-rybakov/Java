package product;

import java.util.ArrayList;
import java.util.Random;

public class GenerateProduct {
    private int idProduct = 0;
    private int maxPrice;
    private int maxCount;
    private Random random = new Random();

    public GenerateProduct() {
        this.maxPrice = 100;
        this.maxCount = 5000;
    }

    public GenerateProduct(int maxPrice, int maxCount) {
        this.maxPrice = maxPrice;
        this.maxCount = maxCount;
    }

    public ArrayList<Product> randomGenerateProduct(int countProducts) {
        ArrayList<Product> allProducts = new ArrayList<Product>();
        for (int i = 0; i < countProducts; i++)
            allProducts.add(this.randomGenerateProduct());
        return allProducts;
    }

    public Product randomGenerateProduct() {
        String name = "product#" + String.valueOf(this.idProduct);
        int price = 1 + random.nextInt(this.maxPrice);
        int count = random.nextInt(this.maxCount);
        this.idProduct++;
        return new Product(name, price, count);
    }
}
