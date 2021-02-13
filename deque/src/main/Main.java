package main;
import java.util.Scanner;

public class Main {
    public static boolean isPalindrome(String line) {
        Deque<Character> checker = new Deque<Character>();
        int n = line.length();
        for (int i = 0; i < n / 2; ++i) {
            checker.addFront(line.charAt(i));
        }
        int begin;
        if (n % 2 == 0) {
            begin = n / 2;
        }
        else {
            begin = n / 2 + 1;
        }
        for (int i = begin; i < n; ++i) {
            if (checker.removeFront() != line.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int req = s.nextInt();

        Deque<Integer> deque = new Deque<Integer>();

        for (int q = 0; q < req; ++q) {
            int type = s.nextInt();
            if (type == 1) {
                int x = s.nextInt();
                deque.addFront(x);
            }
            else if (type == 2) {
                int x = s.nextInt();
                deque.addTail(x);
            }
            else if (type == 3) {
                System.out.println(deque.removeFront());
            }
            else if (type == 4) {
                System.out.println(deque.removeTail());
            }
            deque.display();
        }

        /*System.out.println(isPalindrome("abacaba"));
        System.out.println(isPalindrome("abcdefg"));
        System.out.println(isPalindrome("a"));
        System.out.println(isPalindrome("abba"));
        System.out.println(isPalindrome("jklm"));*/
    }
}
