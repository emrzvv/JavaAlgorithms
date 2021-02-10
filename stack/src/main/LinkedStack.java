package main;

public class LinkedStack<T> {
    public Node<T> head;
    public int count;

    public LinkedStack() {
        count = 0;
        head = null;
    }

    public int size() {
        return count;
    }

    public T pop() {
        if (count == 0) {
            return null;
        }
        Node<T> hold = head;
        if (head.next != null) {
            head = head.next;
        }
        else {
            head = null;
        }
        --count;
        return (T)hold.value;
    }

    public void push(T val) {
        Node<T> n = new Node<T>(val);
        n.next = head;
        head = n;
        ++count;
    }

    public T peek() {
        return (T)head.value;
    }

    public void display() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Node<T> {
    public T value;
    public Node<T> next;
    public Node(T _value) {
        value = _value;
        next = null;
    }
}
