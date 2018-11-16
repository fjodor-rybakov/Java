package supermarket;

import cash_desk.CashDesk;
import customer.Customer;
import product.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Supermarket extends SupermarketStore {
    private Random random = new Random();

    public void start(int numberDay, ArrayList<Customer> allCustomers) {
        this.setWork(true);
        this.setRandomArrival(numberDay, allCustomers.size());
        this.setRandomBuy(allCustomers);
    }

    private void setRandomBuy(ArrayList<Customer> allCustomers) {
        int countTypesProduct, idProduct, countProduct, maxCountTypeProduct = 10;
        CashDesk cashDesk = new CashDesk();
        Product currentProduct;
        for (Customer customer : allCustomers) {
            countTypesProduct = random.nextInt(maxCountTypeProduct);
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
            cashDesk.addCustomerQueue(customer);
            System.out.println("-------------------");
        }
    }

    private void setRandomArrival(int numberDay, int countCustomers) {
        int[] arrWorkTime =  this.getArray(numberDay);
        int timeWork = this.getTime(arrWorkTime);
        System.out.println(timeWork);
        int tempTime;
        ArrayList<Integer> timeArrival = new ArrayList<Integer>();
        for (int i = 0; i < countCustomers; i++) {
            tempTime = random.nextInt(timeWork);
            timeArrival.add(tempTime);
        }
        Collections.sort(timeArrival);
        System.out.println(timeArrival);
    }

    private int[] getArray(int numberDay) {
        String work = this.getWorkTime().get(numberDay - 1);
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
}
