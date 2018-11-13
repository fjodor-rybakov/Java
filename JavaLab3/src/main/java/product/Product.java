package product;

public class Product {
    private String nameProduct;
    private int price;
    private int count;

    public Product(String nameProduct, int price, int count) {
        this.nameProduct = nameProduct;
        this.price = price;
        this.count = count;
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
}
