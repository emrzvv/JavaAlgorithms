package main;
import java.util.Scanner;

public class Main {
    public static boolean parenthesesSequenceChecker(String sequence) {
        Stack<Character> checker = new Stack<Character>();
        int n = sequence.length();
        for (int i = 0; i < n; ++i) {
            if (sequence.charAt(i) == '(') {
                checker.push('(');
            }
            else {
                if (checker.size() > 0) {
                    checker.pop();
                }
                else {
                    return false;
                }
            }
        }
        return checker.size() == 0;
    }

    public static int reversePolishNotationCalculation(String expression) {
        Stack<Integer> calc = new Stack<Integer>();

        int n = expression.length();
        for (int i = 0; i < n; ++i) {
            char current = expression.charAt(i);
            if (current == ' ') {
                continue;
            }
            else {
                if (current == '+') {
                    int acc = 0;
                    while (calc.size() > 0) {
                        acc += calc.pop();
                    }
                    calc.push(acc);
                }
                else if (current == '*') {
                    int acc = 1;
                    while (calc.size() > 0) {
                        acc *= calc.pop();
                    }
                    calc.push(acc);
                }
                else if ('0' <= current && current <= '9') {
                    calc.push(current - '0');
                }
            }
        }
        return calc.pop();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int req = s.nextInt();

        //System.out.println(reversePolishNotationCalculation(s.nextLine()));
        //System.out.println(parenthesesSequenceChecker("(((())()())())"));

        LinkedStack<String> stack = new LinkedStack<String>();

        for (int i = 0; i < req; ++i) {
            int type = s.nextInt();

            if (type == 1) {
                String x = s.next();
                stack.push(x);
            }
            else if (type == 2) {
                System.out.println(stack.pop());
            }
            else if (type == 3) {
                System.out.println(stack.peek());
            }
            else if (type == 4) {
                System.out.println(stack.size());
            }
            //stack.outputData();
            stack.display();
        }
    }
}
