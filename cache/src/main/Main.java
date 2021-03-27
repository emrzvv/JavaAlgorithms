package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);


        NativeCache<Integer> map = new NativeCache<>(5, 1, Integer.class);
        int req = s.nextInt();
        for (int q = 0; q < req; ++q) {
            int type = s.nextInt();
            if (type == 1) {
                String key = s.next();
                int value = s.nextInt();
                map.put(key, value);
            }
            else if (type == 2) {
                String key = s.next();
                if (map.isKey(key)) {
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
            else if (type == 3) {
                String key = s.next();
                System.out.println(map.get(key));
            }
            else if (type == 4) {
                map.outputNonNull();
            }
        }
    }
}
