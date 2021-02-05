package main;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList2 list = new LinkedList2();
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
            else if (type == 5) {
                int x = in.nextInt();
                int y = in.nextInt();
                list.insertAfter(list.find(x), new Node(y));
            }
            else if (type == 6) {
                int x = in.nextInt();
                list.removeAll(x);
            }
            list.display();
            list.displayHeadAndTail();
            if (list.check()) {
                System.out.println("Check Successful");
            }
            else {
                System.out.println("Check fail");
            }
        }

    }
}

