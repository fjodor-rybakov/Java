package product;

import java.util.ArrayList;
import java.util.Random;

public class GenerateProduct {
    private int idProduct = 0;
    private int maxPrice;
    private int maxCount;
    private Random random = new Random();
    private ArrayList<Product> allProducts = new ArrayList<Product>();

    public GenerateProduct() {
        this.maxPrice = 100;
        this.maxCount = 5000;
    }

    public GenerateProduct(int maxPrice, int maxCount) {
        this.maxPrice = maxPrice;
        this.maxCount = maxCount;
    }

    public ArrayList<Product> randomGenerateProducts(int countProducts) {
        String name = "product#" + String.valueOf(this.idProduct);
        int price = 1 + random.nextInt(this.maxPrice);
        int count = random.nextInt(this.maxCount);

        for (int i = 0; i < countProducts; i++) {
            this.allProducts.add(new Product(name, price, count));
            this.idProduct++;
        }

        return this.allProducts;
    }
}
