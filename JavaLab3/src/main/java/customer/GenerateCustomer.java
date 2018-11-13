package customer;

import java.util.ArrayList;
import java.util.Random;

public class GenerateCustomer {
    private int idCustomer = 0;
    private int maxAge;
    private int maxMoney;
    private ArrayList<Customer> allCustomers = new ArrayList<Customer>();
    private Random random = new Random();
    private CustomerCategory customerCategory = new CustomerCategory();

    public GenerateCustomer(int maxAge, int maxMoney) {
        this.maxAge = maxAge;
        this.maxMoney = maxMoney;
    }

    public ArrayList<Customer> randomGenerateCustomer(int countCustomers) {
        String name = "customer#" + String.valueOf(this.idCustomer);
        int age = 1 + random.nextInt(this.maxAge);
        String category = this.customerCategory.getCategory(age);
        int money = random.nextInt(this.maxMoney);

        for (int i = 0; i < countCustomers; i++) {
            allCustomers.add(new Customer(name, category, age, money));
            this.idCustomer++;
        }

        return allCustomers;
    }
}
