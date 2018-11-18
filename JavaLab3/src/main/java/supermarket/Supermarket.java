package supermarket;

import cash_desk.CashDesk;
import customer.Customer;
import product.Product;

import java.util.*;

public class Supermarket extends CashDesk {
    private Random random = new Random();
    private SupermarketStore store = new SupermarketStore();
    private ArrayList<Product> dataProducts = new ArrayList<Product>();

    public void start(int numberDay, ArrayList<Customer> allCustomers) {
        store.setWork(true);
        ArrayList<Integer> timeArrival = this.setRandomArrival(numberDay, allCustomers.size());
        ArrayList<Customer> allCustomersWithBasket = this.setRandomBuy(allCustomers);
        this.updateTimeCustomer(timeArrival, allCustomersWithBasket);
    }

    private ArrayList<Customer> setRandomBuy(ArrayList<Customer> allCustomers) {
        int countTypesProduct, maxCountTypeProduct = 10;
        for (Customer customer : allCustomers) {
            countTypesProduct = random.nextInt(maxCountTypeProduct);
            this.fillBasketCustomer(countTypesProduct, customer);
            System.out.println("-------------------");
        }
        return allCustomers;
    }

    private void fillBasketCustomer(int countTypesProduct, Customer customer) {
        int idProduct, countProduct;
        Product currentProduct;
        for (int i = 0; i < countTypesProduct; i++) {
            idProduct = random.nextInt(this.getDataProducts().size());
            currentProduct = this.getDataProducts().get(idProduct);
            countProduct = random.nextInt(currentProduct.getCount());
            if (countProduct == 0) {
                continue;
            }
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

    private void updateTimeCustomer(ArrayList<Integer> timeArrival, ArrayList<Customer> allCustomersWithBasket) {
        Map<Customer, Integer> newTimeArrivalCustomer = new HashMap<>();
        int allSpendTime;
        for (int i = 0; i < timeArrival.size(); i++) {
            allSpendTime = allCustomersWithBasket.get(i).getBasket().size() + timeArrival.get(i);
            newTimeArrivalCustomer.put(allCustomersWithBasket.get(i), allSpendTime);
        }
        int lastTime = 0;
        newTimeArrivalCustomer = this.sortByValue(newTimeArrivalCustomer);
        for (Map.Entry<Customer, Integer> queue : newTimeArrivalCustomer.entrySet()) {
            lastTime = lastTime > queue.getValue() ? lastTime + 1 : queue.getValue() + 1;
            this.addCustomerQueue(queue.getKey());
            System.out.println(queue.getValue() + " - " + queue.getKey().getName());
            System.out.println("[time " + lastTime + "] Customer - " + queue.getKey().getName() + " leave from supermarket");
            this.removeCustomerQueue();
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

    private ArrayList<Integer> setRandomArrival(int numberDay, int countCustomers) {
        int[] arrWorkTime =  this.getArrayTime(numberDay);
        int timeWork = this.getTime(arrWorkTime);
        System.out.println("[Work time] " + timeWork);
        int tempTime;
        ArrayList<Integer> timeArrival = new ArrayList<Integer>();
        for (int i = 0; i < countCustomers; i++) {
            tempTime = random.nextInt(timeWork);
            timeArrival.add(tempTime);
        }
        Collections.sort(timeArrival);
        System.out.println(timeArrival);
        return timeArrival;
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
        System.out.println(Arrays.toString(arr));
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
