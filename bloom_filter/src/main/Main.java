package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BloomFilter bf = new BloomFilter(32);


        Scanner s = new Scanner(System.in);
	    int req = s.nextInt();
	    for (int q = 0; q < req; ++q) {
	        int type = s.nextInt();
	        if (type == 1) {
	            String val = s.nextLine();
                bf.add(val);
            }
	        if (type == 2) {
	            String val = s.nextLine();
	            System.out.println(bf.isValue(val));
            }
        }
    }
}
