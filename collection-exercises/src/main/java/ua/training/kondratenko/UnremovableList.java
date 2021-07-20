package ua.training.kondratenko;

import java.util.ArrayList;
import java.util.List;

public class UnremovableList extends ArrayList {

    @Override
    public Object remove(int index) {
        throw new UnsupportedOperationException("Removing is impossible!");
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Removing is impossible!");
    }

    public static void main(String[] args) {

        List<Integer> integers = new UnremovableList();
        integers.add(2);
        integers.add(5);
        integers.add(9);
        integers.add(3);

        integers.remove(0);

        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
