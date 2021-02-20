package main;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        OrderedList<Integer> ol = new OrderedList<>(true);
        int req = s.nextInt();
        for (int q = 0; q < req; ++q) {
            int type = s.nextInt();
            if (type == 1) {
                int x = s.nextInt();
                ol.add(x);
            }
            else if (type == 2) {
                int x = s.nextInt();
                ol.delete(x);
            }
            else if (type == 3) {
                int x = s.nextInt();
                Node<Integer> found = ol.find(x);
                System.out.println(found != null ? found.value : "not found");
            }
            else if (type == 4) {
                ol.clear(true);
            }
            else if (type == 5) {
                System.out.println(ol.count());
            }
            else if (type == 6) {
                System.out.println(ol.check());
            }
            ol.displayHeadAndTail();
            ol.display();
        }
    }
}
