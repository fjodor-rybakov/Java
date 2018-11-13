package discount;

import java.util.HashMap;
import java.util.Map;

public class Discount {
    private Map<String, Boolean> isDiscountProducts = new HashMap<String, Boolean>();

    public Map<String, Boolean> getIsDiscountProducts() {
        return isDiscountProducts;
    }

    public void setIsDiscountProducts(String nameProduct, boolean isDiscount) {
        this.isDiscountProducts.put(nameProduct, isDiscount);
    }
}
