package supermarket;

import java.util.Arrays;

public class Supermarket extends SupermarketStore {
    public void start(int numberDay) {
        this.setWork(true);

        while (this.isWork()) {
            try {
                Thread.sleep(1);
            } catch (Exception error) {
                System.out.println(Arrays.toString(error.getStackTrace()));
            }
            this.checkWorkTime(numberDay, 1);
            this.setWork(false);
        }
    }

    private boolean checkWorkTime(int numberDay, int time) {
        return true;
    }
}
