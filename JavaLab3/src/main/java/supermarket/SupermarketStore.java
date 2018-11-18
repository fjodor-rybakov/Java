package supermarket;

import product.Product;

import java.util.ArrayList;
import java.util.Arrays;

public class SupermarketStore {
    private boolean isWork = false;
    private ArrayList<String> workTime = new ArrayList<String>(
            Arrays.asList("8,00,22,00", "8,00,22,00", "8,00,22,00", "8,00,22,00", "8,30,22,20", "10,00,20,00", "10,00,20,00")
    );

    public ArrayList<String> getWorkTime() {
        return this.workTime;
    }

    public void setWorkTime(int dayIndex, String newWorkTime) {
        this.workTime.set(dayIndex, newWorkTime);
    }

    protected boolean isWork() {
        return isWork;
    }

    protected void setWork(boolean work) {
        isWork = work;
    }
}
