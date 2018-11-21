package customer;

import basket.Basket;
import payment_method.PaymentMethod;

public class Customer extends Basket {
    private String name;
    private String customerCategory;
    private int age;
    private int countMoney;
    private PaymentMethod paymentMethod = new PaymentMethod();

    public Customer(String name, String customerCategory, int age, int countMoney) {
        this.name = name;
        this.customerCategory = customerCategory;
        this.age = age;
        this.countMoney = countMoney;
    }

    public String getName() {
        return name;
    }

    public String getCustomerCategory() {
        return customerCategory;
    }

    public int getAge() {
        return age;
    }

    public int getCountMoney() {
        return countMoney;
    }

    public PaymentMethod getPaymentMethods() {
        return paymentMethod;
    }
}
