package discount;

import java.util.Random;

public class Discount {
    private int discount;

    public Discount(int maxDiscount) {
        Random random = new Random();
        discount = random.nextInt(maxDiscount + 1);
    }

    public int getDiscount(int price) {
        return price - (price * discount / 100);
    }
}
