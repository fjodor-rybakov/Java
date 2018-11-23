import org.junit.jupiter.api.Test;

import product.GenerateProduct;
import product.Product;
import report.Report;
import supermarket.Supermarket;
import supermarket.SupermarketStore;
import utils.Utils;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestSupermarketSimulator {
    private GenerateProduct generateProduct = new GenerateProduct(150, 1000);
    private ArrayList<Product> allProducts = generateProduct.randomGenerateProduct(30);
    private SupermarketStore store = new SupermarketStore();

    @Test
    public void checkSetProductSupermarket() {
        Supermarket supermarket = new Supermarket();
        supermarket.setDataProducts(allProducts);
        assertEquals(supermarket.getDataProducts().size() > 0, supermarket.isSetDataProducts());
    }

    @Test void checkGetTime() {
        int[] timeArray = Utils.getArrayTime(5, store.getWorkTime());
        int[] expectResultTimeArray = {8, 30, 22, 20};
        assertArrayEquals(expectResultTimeArray, timeArray);
        int time = Utils.getTime(timeArray);
        assertEquals(time, 830);
    }

    @Test void checkSortByValue() {
        Map<String, Integer> data = new HashMap<>();
        int value = 9;
        for (int i = 0; i < 10; i++) {
            data.put("str" + String.valueOf(i), value--);
        }
        Map<String, Integer> result = Utils.sortByValue(data);
        Map<String, Integer> expectResult = new LinkedHashMap<>();
        for (int i = 0; i < 10; i++) {
            expectResult.put("str" + String.valueOf(i), i);
        }
        for (int i = 0; i < 10; i++) {
            assertArrayEquals(result.values().toArray(), expectResult.values().toArray());
        }
    }

    @Test
    public void checkReport() {
        Report report = new Report();
        Supermarket supermarket = new Supermarket();
        supermarket.setDataProducts(allProducts);
        supermarket.start(5, report);
        assertTrue(report.getDataReport().size() > 0);
    }
}
