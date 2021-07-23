package ua.training.kondratenko.stream;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

public class StreamMaker {
    public static void main(String[] args) {
        int[] array = {5, -6, 12, 32, 9, 0, 1};

        final IntStream intStream = Arrays.stream(array);

        final OptionalDouble average = intStream.average();

        final double averageAsDouble = average.getAsDouble();

        System.out.println("Average number is: " + (int) averageAsDouble);

        final int min = Arrays.stream(array).min().getAsInt();

        System.out.println("Minimal value is: " + min);

        int minIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == min) {
                minIndex = i;
            }
        }

        System.out.println("Minimal value index is: " + minIndex);

        final long zeroElementCount = Arrays.stream(array).filter(number -> number == 0).count();

        System.out.println("Number of elements equals 0: " + zeroElementCount);

        final long greaterThanZero = Arrays.stream(array).filter(number -> number > 0).count();

        System.out.println("Number of elements greater than 0: " + greaterThanZero);

        final int[] multiplied = Arrays.stream(array).map(number -> number * 2).toArray();

        System.out.println("Multiplied by 2: " + Arrays.toString(multiplied));
    }
}
