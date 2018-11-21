package utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public static int[] getArrayTime(int numberDay, ArrayList<String> workTimeList) {
        String work = workTimeList.get(numberDay - 1);
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

    public static int getTime(int[] times) {
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

    public static  <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
