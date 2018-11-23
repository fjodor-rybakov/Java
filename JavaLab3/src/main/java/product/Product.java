package product;

public class Product implements IProduct {
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

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public boolean isAcceptAge() {
        return isAcceptAge;
    }
}
