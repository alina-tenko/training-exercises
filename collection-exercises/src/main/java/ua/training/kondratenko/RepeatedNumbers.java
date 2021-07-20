package ua.training.kondratenko;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedNumbers {

    private final static List<Integer> numbers = new ArrayList<>();

    static {
        numbers.add(4);
        numbers.add(5);
        numbers.add(-6);
        numbers.add(4);
        numbers.add(5);
        numbers.add(3);
        numbers.add(4);
        numbers.add(2);
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();

        for (Integer number : numbers) {
            if (map.containsKey(number)) {
                Integer existedValue = map.get(number);

                existedValue = existedValue + 1;

                map.replace(number, existedValue);
            } else {
                map.put(number, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
