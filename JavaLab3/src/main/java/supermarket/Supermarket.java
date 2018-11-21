package supermarket;

import discount.Discount;
import report.Report;
import utils.Utils;
import bill.Bill;
import cash_desk.CashDesk;
import customer.Customer;
import customer.GenerateCustomer;
import product.Product;
import java.util.*;

public class Supermarket extends SupermarketStore {
    private Random random = new Random();
    private CashDesk cashDesk = new CashDesk();
    private GenerateCustomer generateCustomer = new GenerateCustomer(100, 10000);
    private Map<Customer, Integer> allCustomers = new HashMap<>();
    private Discount discount = new Discount(20);

    public void start(int numberDay, Report report) {
        this.setWork(true);
        System.out.println("Supermarket is opened");
        int time = 0, maxCountCustomers = 1 + random.nextInt(3);
        int[] arrWorkTime = Utils.getArrayTime(numberDay, this.getWorkTime());
        int timeWork = Utils.getTime(arrWorkTime), bill, type;
        String message = "[Work time] " + timeWork + " min";
        System.out.println(message);
        Customer currentCustomer;

        while (time != timeWork) {
            currentCustomer = this.getCurrentCustomer(time);
            if (currentCustomer != null) {
                cashDesk.addCustomerQueue(currentCustomer, time);
                this.allCustomers.remove(currentCustomer);
            }
            if (cashDesk.getAllCustomerQueue().size() != 0 && cashDesk.getCustomerQueue().getValue() == time) {
                currentCustomer = cashDesk.getCustomerQueue().getKey();
                String name = currentCustomer.getName();
                ArrayList<Product> restoreProducts = cashDesk.filterProduct(currentCustomer);
//                System.out.println(restoreProducts);
                for (Product product : restoreProducts) {
                    this.updateDataProduct(product.getCount(), product);
                }
                bill = Bill.getBill(currentCustomer);
                if (currentCustomer.getCustomerCategory().equals("Retired")) {
                    bill -= this.discount.getDiscount(bill);
                }
                type = random.nextInt(3);
                System.out.println("[time " + time + "] Customer - " + name + " at the cash desk, amount to pay: " + bill);
                this.setRevenue(bill + this.getRevenue());
                System.out.println("[time " + time + "] Customer paid " + bill + " by " + currentCustomer.getPaymentMethods().getTypePayment(type));
                cashDesk.removeCustomerQueue();
                System.out.println("[time " + time + "] Customer - " + name + " leave from supermarket");
            }
            if (time == 829) {
                ArrayList<Customer> newCustomers = this.generateCustomer.randomGenerateCustomer(maxCountCustomers);
                this.setRandomBuy(time, newCustomers);
            }
            if (this.isSetRandomArrival() && this.isWork()) {
                ArrayList<Customer> newCustomers = this.generateCustomer.randomGenerateCustomer(maxCountCustomers);
                this.setRandomBuy(time, newCustomers);
            }
            time++;
            if (time == timeWork && this.allCustomers.size() != 0) {
                this.setWork(false);
                timeWork++;
            }
        }
        message = "Supermarket work " + timeWork + " min";
        System.out.println(message);
        System.out.println("Supermarket is closed");
        report.getDataReport().add(message);
        for (Product product : this.getDataProducts()) {
            report.getDataReport().add(
                    "[" + product.getNameProduct() +
                    ", price: " + product.getPrice() +
                    ", count: " + product.getCount() +
                    ", isAcceptAge: " + product.isAcceptAge() + "]"
            );
        }
        report.getDataReport().add("Revenue per day: " + this.getRevenue());
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

    private void setRandomBuy(int time, ArrayList<Customer> allCustomers) {
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
            if (customer.getCountMoney() < Bill.getBill(customer)) {
                break;
            }
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
            Product newProduct = new Product(
                    currentProduct.getNameProduct(),
                    currentProduct.getPrice(),
                    countProductByCustomer,
                    currentProduct.isAcceptAge()
            );
            customer.addBasket(newProduct);
        }
    }
}
