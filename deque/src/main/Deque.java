package main;

import java.util.*;

public class Deque<T>
{
    public Node<T> head;
    public Node<T> tail;
    public int count;

    public Deque()
    {
        count = 0;
        head = null;
        tail = null;
    }

    public void addFront(T item)
    {
        Node<T> n = new Node<T>(item);
        if (head == null) {
            head = n;
            tail = n;
        }
        else {
            n.next = this.head;
            this.head = n;
        }
        count++;
    }

    public void addTail(T item)
    {
        Node<T> n = new Node<T>(item);
        if (head == null) {
            head = n;
        }
        else {
            tail.next = n;
        }
        tail = n;
        count++;
    }

    public T removeFront()
    {
        if (head == null) {
            return null;
        }
        if (head.equals(tail)) {
            count--;
            Node<T> r = head;
            head = null;
            tail = null;
            return r.value;
        }
        count--;
        Node<T> r = head;
        head = head.next;
        return r.value;
    }

    public T removeTail()
    {
        if (tail == null) {
            return null;
        }
        if (head.equals(tail)) {
            count--;
            Node<T> r = tail;
            head = null;
            tail = null;
            return r.value;
        }
        count--;
        Node<T> current = head;
        Node<T> previous = null;
        while (!current.equals(tail)) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        return current.value;
    }

    public int size()
    {
        return count;
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