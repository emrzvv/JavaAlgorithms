package main;

public class Main {

    public static void main(String[] args) {
	    int[] data = new int[]{5, 4, -1, 0, 99, 3};
	    Sorts.quickSort(data, 0, data.length - 1);
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }
}
