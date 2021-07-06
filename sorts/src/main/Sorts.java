package main;

import java.util.Random;

public class Sorts {

    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private static int partition(int[] data, int from, int to) {
        int left = from, right = to;
        int middle = from;
        while (left <= right) {
            while (data[left] < data[middle]) {
                left++;
            }

            while (data[right] > data[middle]) {
                right--;
            }

            if (left <= right) {
                swap(data, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    public static void quickSort(int[] data, int from, int to) {
        if (from < to) {
            int partitionIndex = partition(data, from , to);

            quickSort(data, from, partitionIndex - 1);

            quickSort(data, partitionIndex, to);
        }
    }
}
