package product;

import discount.Discount;

public class Product extends Discount {
    private String nameProduct;
    private int price;
    private int count;
    private boolean isAcceptAge;

    public Product(String nameProduct, int price, int count, boolean isAcceptAge) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.count = count;
        this.isAcceptAge = isAcceptAge;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isAcceptAge() {
        return isAcceptAge;
    }

    public void setAcceptAge(boolean acceptAge) {
        isAcceptAge = acceptAge;
    }
}
