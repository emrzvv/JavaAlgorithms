package main;

import java.util.*;

class Node<T>
{
    public T value;
    public Node<T> next, prev;

    public Node(T _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T>
{
    public Node<T> head, tail;
    private boolean _ascending;
    public int amount;

    public OrderedList(boolean asc)
    {
        head = null;
        tail = null;
        _ascending = asc;
        amount = 0;
    }

    public void addInTail(Node<T> _item)
    {
        if (head == null) {
            head = _item;
            head.next = null;
            head.prev = null;
        } else {
            tail.next = _item;
            _item.prev = tail;
        }
        tail = _item;
    }

    public int compare(T v1, T v2)
    {
        if (head.value.getClass().equals(Integer.class)) {
            int i1 = (int)v1;
            int i2 = (int)v2;
            if (i1 < i2) {
                return -1;
            }
            else if (i1 > i2) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else if (head.value.getClass().equals(String.class)) {
            String s1 = (String)v1;
            String s2 = (String)v2;
            return s1.compareTo(s2);
        }
        return 0;
    }

    public void add(T value)
    {
        Node<T> current = head;
        Node<T> n = new Node<T>(value);

        int cmpFlag = 1;
        if (_ascending) cmpFlag = -1;

        if (head == null) {
            addInTail(n);
            amount++;
            return;
        }
        else if (compare(head.value, n.value) == (-1) * cmpFlag) {
            current = null;
        }
        else {
            while (current != tail && compare(current.next.value, n.value) == cmpFlag) {
                current = current.next;
            }
        }

        if (current == head) {
            if (head == null || head == tail) {
                addInTail(n);
            }
            else {
                head.next.prev = n;
                n.next = head.next;
                head.next = n;
                n.prev = head;
            }
        }
        else if (current == tail) {
            addInTail(n);
        }
        else if (current == null) {
            n.next = head;
            if (head != null) {
                head.prev = n;
            }
            head = n;
        }
        else {
            current.next.prev = n;
            n.next = current.next;
            current.next = n;
            n.prev = current;
        }
        amount++;
    }

    public Node<T> find(T val)
    {
        Node<T> current = head;
        int cmpFlag = 1;
        if (_ascending) cmpFlag = -1;
        while (current != null && compare(current.value, val) == cmpFlag) {
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        else return compare(current.value, val) == 0 ? current : null;
    }

    public void delete(T val)
    {
        if (head != null) {
            if (compare(head.value, val) == 0) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                }
            }
            else if (compare(tail.value, val) == 0) {
                tail = tail.prev;
                tail.next = null;
            }
            else {
                Node<T> current = head;
                int cmpFlag = 1;
                if (_ascending) cmpFlag = -1;
                while (current != null && compare(current.value, val) == cmpFlag) {
                    current = current.next;
                }
                if (current == head || current == tail) {
                    return;
                }
                else if (current != null) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                else {
                    if (head == null) {
                        tail = null;
                    }
                    return;
                }
            }
            if (head == null) {
                tail = null;
            }
            amount--;
        }
    }

    public void clear(boolean asc)
    {
        _ascending = asc;
        amount = 0;
        if (head != null) {
            while (head != tail) {
                head = head.next;
            }
            head = null;
            tail = null;
        }
    }

    public int count()
    {
        return amount;
    }

    ArrayList<Node<T>> getAll()
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while(node != null)
        {
            r.add(node);
            node = node.next;
        }
        return r;
    }

    public void display() {
        Node<T> current = this.head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.print("\n");
    }

    public void displayHeadAndTail() {
        System.out.println("Head: " + this.head + " Tail: " + this.tail);
    }

    public boolean check() {
        Node<T> current = this.head;
        Node<T> rcurrent = this.tail;
        int forward = 0, backward = 0;
        while (current != null) {
            current = current.next;
            forward++;
        }

        while (rcurrent != null) {
            rcurrent = rcurrent.prev;
            backward++;
        }

        return forward == backward && this.count() == forward;
    }
}