package main;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PowerSet set = new PowerSet();

        PowerSet hold = new PowerSet();
        hold.put("a");
        hold.put("b");
        hold.put("c");
        hold.put("d");
        hold.put("e");

        int q = s.nextInt();
        s.nextLine();
        for (int req = 0; req < q; ++req) {
            String[] line = s.nextLine().split(" ");
            int type = Integer.parseInt(line[0]);
            if (type == 0) {
                System.out.println(set.size());
            }
            else if (type == 1) {
                String x = line[1];
                set.put(x);
            }
            else if (type == 2) {
                String x = line[1];
                System.out.println(set.get(x));
            }
            else if (type == 3) {
                String x = line[1];
                System.out.println(set.remove(x));
            }
        }
        PowerSet a = set.intersection(hold);
        a.display();
        System.out.println(a.size());

        PowerSet b = set.union(hold);
        b.display();
        System.out.println(b.size());

        PowerSet c = set.difference(hold);
        System.out.println(c.size());
        c.display();

        System.out.println(set.isSubset(hold));
    }
}
