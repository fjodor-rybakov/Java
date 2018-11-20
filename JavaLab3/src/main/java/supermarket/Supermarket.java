package supermarket;

import Utils.Utils;
import cash_desk.CashDesk;
import customer.Customer;
import customer.GenerateCustomer;
import javafx.util.Pair;
import product.Product;
import java.util.*;

public class Supermarket extends CashDesk {
    private Random random = new Random();
    private SupermarketStore store = new SupermarketStore();
    private GenerateCustomer generateCustomer = new GenerateCustomer(100, 10000);
    private Map<Customer, Integer> allCustomers = new HashMap<>();
    private ArrayList<Product> dataProducts;

    public void start(int numberDay) {
        store.setWork(true);
        int time = 0, maxCountCustomers = 1 + random.nextInt(3);
        int[] arrWorkTime = Utils.getArrayTime(numberDay, this.store.getWorkTime());
        int timeWork = Utils.getTime(arrWorkTime);
        Pair<Customer, Integer> removeCustomer;
        System.out.println("[Work time] " + timeWork + " min");
        Customer currentCustomer;

        while (time != timeWork) {
            currentCustomer = this.getCurrentCustomer(time);
            if (currentCustomer != null) {
                this.addCustomerQueue(currentCustomer, time);
                this.allCustomers.remove(currentCustomer);
            }
            if (this.getAllCustomerQueue().size() != 0 && this.getCustomerQueue().getValue() == time) {
                removeCustomer = this.removeCustomerQueue();
                String name = removeCustomer.getKey().getName();
                int leaveTime = removeCustomer.getValue();
                System.out.println("[time " + leaveTime + "] Customer - " + name + " leave from supermarket");
            }
            if (time == 829) {
                ArrayList<Customer> newCustomers = this.generateCustomer.randomGenerateCustomer(maxCountCustomers);
                this.setRandomBuy(time, newCustomers);
            }
            if (this.isSetRandomArrival() && this.store.isWork()) {
                ArrayList<Customer> newCustomers = this.generateCustomer.randomGenerateCustomer(maxCountCustomers);
                this.setRandomBuy(time, newCustomers);
            }
            time++;
            if (time == timeWork && this.allCustomers.size() != 0) {
                store.setWork(false);
                timeWork++;
            }
        }
    }

    private boolean isSetRandomArrival() {
        return random.nextInt(100) == 0;
    }

    private Customer getCurrentCustomer(int time) {
        if (this.allCustomers.size() == 0) {
            return null;
        }
        for (Map.Entry<Customer, Integer> item : this.allCustomers.entrySet()) {
            if (item.getValue() == time - 1) {
                return item.getKey();
            }
        }
        return null;
    }

    private ArrayList<Customer> setRandomBuy(int time, ArrayList<Customer> allCustomers) {
        int countTypesProduct, maxCountTypeProduct = 10;
        for (Customer customer : allCustomers) {
            System.out.println("[time " + time + "] Customer " + customer.getName() + " is arrival");
            countTypesProduct = random.nextInt(maxCountTypeProduct);
            this.fillBasketCustomer(time, countTypesProduct, customer);
            if (customer.getBasket().size() == 0) {
                System.out.println("[time " + time + "] Customer - " + customer.getName() + " leave from supermarket");
            } else {
                this.allCustomers.put(customer, checkAllTime(time + customer.getBasket().size()));
            }
        }
        return allCustomers;
    }

    private int checkAllTime(int time) {
        if (this.allCustomers.size() == 0) {
            return time;
        }
        for (Map.Entry<Customer, Integer> item : Utils.sortByValue(this.allCustomers).entrySet()) {
            if (item.getValue() == time) {
                time++;
            }
        }
        return time;
    }

    private void fillBasketCustomer(int time, int countTypesProduct, Customer customer) {
        int idProduct, countProductByCustomer, currentCountProduct;
        Product currentProduct;
        for (int i = 0; i < countTypesProduct; i++) {
            idProduct = random.nextInt(this.getDataProducts().size());
            currentProduct = this.getDataProducts().get(idProduct);
            if (currentProduct.getCount() == 0) {
                continue;
            }
            countProductByCustomer = random.nextInt(currentProduct.getCount() + 1);
            currentCountProduct = currentProduct.getCount() - countProductByCustomer;
            if (currentCountProduct < 0) {
                countProductByCustomer = countProductByCustomer - currentCountProduct;
                currentCountProduct = 0;
            }
            this.updateDataProduct(currentCountProduct, idProduct);
            if (this.getDataProducts().get(idProduct).getCount() == 0) {
                System.out.println( "[time " + (time + i) + "] Product " + currentProduct.getNameProduct() + " is over");
            }
            System.out.println("[time " + (time + i) + "] Customer " + customer.getName() + " picked up " + countProductByCustomer + " units of " + currentProduct.getNameProduct());
            Product newProduct = new Product(currentProduct.getNameProduct(), currentProduct.getPrice(), countProductByCustomer);
            customer.addBasket(newProduct);
        }
    }

    public ArrayList<Product> getDataProducts() {
        return this.dataProducts;
    }

    public void setDataProducts(ArrayList<Product> dataProducts) {
        this.dataProducts = dataProducts;
    }

    public void addDataProducts(Product product) {
        this.dataProducts.add(product);
    }

    public void updateDataProduct(int count, int index) {
        String name = this.dataProducts.get(index).getNameProduct();
        int price = this.dataProducts.get(index).getPrice();
        Product temp = new Product(name, price, count);
        this.dataProducts.set(index, temp);
    }

    public void updateDataProduct(String nameProduct, int price, int count, int index) {
        Product temp = new Product(nameProduct, price, count);
        this.dataProducts.set(index, temp);
    }
}
