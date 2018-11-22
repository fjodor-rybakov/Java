package product;

public interface IProduct {
    String getNameProduct();
    void setNameProduct(String nameProduct);

    int getPrice();
    void setPrice(int price);

    int getCount();
    void setCount(int count);

    boolean isAcceptAge();
    void setAcceptAge(boolean acceptAge);
}
