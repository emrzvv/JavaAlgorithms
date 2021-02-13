package main;
import java.util.Scanner;

public class Main {
    public static <T> void queueShift(Queue<T> queue, int n) {
        while (n > 0) {
            queue.enqueue(queue.dequeue());
            --n;
        }
        queue.display();
    }

    public static void main(String[] args) {

        Queue<Integer> queue = new Queue<Integer>();

        Scanner s = new Scanner(System.in);
        int req = s.nextInt();
        for (int q = 0; q < req; ++q) {
            int type = s.nextInt();
            if (type == 1) {
                int x = s.nextInt();
                queue.enqueue(x);
            }
            else if (type == 2) {
                System.out.println(queue.dequeue());
            }
            else if (type == 3) {
                System.out.println(queue.size());
            }
            queue.display();
        }
    }
}
