package main;
import java.util.Scanner;

public class Main {
    public static LinkedList summary(LinkedList a, LinkedList b) {
        if (a.count() == b.count()) {
            LinkedList list = new LinkedList();
            Node current_a = a.head, current_b = b.head;

            while (current_a != null) {
                Node n = new Node(current_a.value + current_b.value);
                list.addInTail(n);
                current_a = current_a.next;
                current_b = current_b.next;
            }

            return list;
        }
        else {
            return null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 0; i < q; ++i) {
            int type = in.nextInt();
            if (type == 1) {
                // System.out.println("Add in tail: \n");
                int x = in.nextInt();
                Node n = new Node(x);
                list.addInTail(n);
            }
            else if (type == 2) {
                // System.out.println("Find: \n");
                int x = in.nextInt();
                Node n = list.find(x);
                if (n != null) {
                    System.out.println("Found\n");
                }
                else {
                    System.out.println("Not found\n");
                }
            }
            else if (type == 3) {
                // System.out.println("Remove: \n");
                int x = in.nextInt();
                if (list.remove(x) == true) {
                    System.out.println("Removed\n");
                }
                else {
                    System.out.println("Not removed");
                }
            }
            else if (type == 4) {
                int cnt = list.count();
                System.out.printf("Count: %d\n", cnt);
            }
            list.display();
            list.displayHeadAndTail();
        }

    }
}

