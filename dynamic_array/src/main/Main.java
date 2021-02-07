package main;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
	    int req = s.nextInt();

	    DynArray d = new DynArray(Integer.class);
        for (int i = 0; i < req; ++i) {
            int type = s.nextInt();
            if (type == 1) {
                int index = s.nextInt();
                System.out.println(d.getItem(index));
            }
            else if (type == 2){
                int item = s.nextInt();
                d.append(item);
            }
            else if (type == 3) {
                int item = s.nextInt(), index = s.nextInt();
                d.insert(item, index);
            }
            else if (type == 4) {
                int index = s.nextInt();
                d.remove(index);
            }
            d.display();
        }
    }
}
