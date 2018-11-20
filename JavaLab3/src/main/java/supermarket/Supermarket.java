package supermarket;

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
        int[] arrWorkTime =  this.getArrayTime(numberDay);
        int timeWork = this.getTime(arrWorkTime);
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

    private int[] getArrayTime(int numberDay) {
        String work = store.getWorkTime().get(numberDay - 1);
        String[] times = work.split(",");
        int[] arr = new int[4];
        try {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(times[i]);
            }
        } catch (Exception error) {
            System.out.println(error.getMessage());
        }
        return arr;
    }

    private int getTime(int[] times) {
        int result = 0;
        if (times[0] < times[2]) {
            result += (times[2] - times[0]) * 60;
        } else {
            result += (24 - times[0] - times[2]) * 60;
        }
        if (times[1] < times[3]) {
            result += times[3] + times[1];
        } else {
            result += times[3] - times[1];
        }
        return result;
    }

    private ArrayList<Customer> setRandomBuy(int time, ArrayList<Customer> allCustomers) {
        int countTypesProduct, maxCountTypeProduct = 10;
        for (Customer customer : allCustomers) {
            System.out.println("[time " + time + "] Customer " + customer.getName() + " is arrival");
            countTypesProduct = random.nextInt(maxCountTypeProduct);
            this.fillBasketCustomer(countTypesProduct, customer);
            System.out.println("size " + customer.getBasket().size());
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
        for (Map.Entry<Customer, Integer> item : this.sortByValue(this.allCustomers).entrySet()) {
            if (item.getValue() == time) {
                time++;
            }
        }
        return time;
    }

    private void fillBasketCustomer(int countTypesProduct, Customer customer) {
        int idProduct, countProduct;
        Product currentProduct;
        for (int i = 0; i < countTypesProduct; i++) {
            idProduct = random.nextInt(this.getDataProducts().size());
            currentProduct = this.getDataProducts().get(idProduct);
            if (currentProduct.getCount() == 0) {
                continue;
            }
            countProduct = random.nextInt(currentProduct.getCount());
            this.updateDataProduct(currentProduct.getCount() - countProduct, idProduct);
            if (this.getDataProducts().get(idProduct).getCount() == 0) {
                System.out.println("Products is over");
            }
            System.out.println(currentProduct.getNameProduct());
            System.out.println(countProduct);
            Product newProduct = new Product(currentProduct.getNameProduct(), currentProduct.getPrice(), countProduct);
            customer.addBasket(newProduct);
        }
    }

    private <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
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
