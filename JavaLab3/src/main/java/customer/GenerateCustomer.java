package customer;

import java.util.ArrayList;
import java.util.Random;

public class GenerateCustomer {
    private int idCustomer = 0;
    private int maxAge;
    private int maxMoney;
    private Random random = new Random();
    private CustomerCategory customerCategory = new CustomerCategory();

    public GenerateCustomer() {
        this.maxAge = 100;
        this.maxMoney = 10000;
    }

    public GenerateCustomer(int maxAge, int maxMoney) {
        this.maxAge = maxAge;
        this.maxMoney = maxMoney;
    }

    public ArrayList<Customer> randomGenerateCustomer(int countCustomers) {
        ArrayList<Customer> allCustomers = new ArrayList<Customer>();
        for (int i = 0; i < countCustomers; i++)
            allCustomers.add(this.randomGenerateCustomer());
        return allCustomers;
    }

    public Customer randomGenerateCustomer() {
        String name = "customer#" + String.valueOf(this.idCustomer);
        int age = 1 + random.nextInt(this.maxAge);
        String category = this.customerCategory.getCategory(age);
        int money = random.nextInt(this.maxMoney);
        this.idCustomer++;
        return new Customer(name, category, age, money);
    }
}
