package customer;

import basket.Basket;

import java.util.ArrayList;
import java.util.Arrays;

public class Customer extends Basket {
    private String name;
    private String customerCategory;
    private int age;
    private int countMoney;
    private ArrayList<String> typesPayment = new ArrayList<>(
            Arrays.asList("card", "cash", "bonus")
    );

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

    public String getTypesPayment(int indexType) {
        return this.typesPayment.get(indexType);
    }
}
