package customer;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomerCategory {
    private ArrayList<String> category = new ArrayList<String>(
            Arrays.asList("Child", "Adult", "Retired")
    );

    public String getCategory(int age) {
        int value = age < 18 ? 0 : age < 65 ? 1 : 2;
        return this.category.get(value);
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }


}
