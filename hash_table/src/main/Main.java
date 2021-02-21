package main;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    HashTable table = new HashTable(2011, 1);
	    Scanner s = new Scanner(System.in);
        int req = s.nextInt();
        for (int q = 0; q < req; ++q) {
            int type = s.nextInt();
            if (type == 1) {
                String line = s.nextLine();
                if (table.put(line) != -1) {
                    System.out.println("inserted " + line);
                }
                else {
                    System.out.println("not inserted");
                }
            }
            else if (type == 2) {
                String line = s.nextLine();
                int result = table.find(line);
                if (result != -1) {
                    System.out.println(result);
                }
                else {
                    System.out.println("not found");
                }
            }
            else if (type == 3) {
                String line = s.nextLine();
                int result = table.seekSlot(line);
                System.out.println(result);
            }
            table.outputNonNull();
        }
    }
}
