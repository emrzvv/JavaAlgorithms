package main;

import java.util.*;

public class LinkedList2
{
    public Node head;
    public Node tail;

    public LinkedList2()
    {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item)
    {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node find(int _value) {
        Node current = this.head;
        while (current != null) {
            if (current.value == _value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value)
    {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node current = this.head;
        while (current != null) {
            if (current.value == _value) {
                nodes.add(current);
            }
            current = current.next;
        }
        return nodes;
    }

    public boolean remove(int _value)
    {
        if (this.head != null) {
            if (this.head.value == _value) {
                this.head = this.head.next;
                if (this.head != null) {
                    this.head.prev = null;
                }
            }
            else if (this.tail.value == _value) {
                this.tail = this.tail.prev;
                this.tail.next = null;
            }
            else {
                Node current = this.head;
                while (current != null && current.value != _value) {
                    current = current.next;
                }
                if (current != null) {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                else {
                    if (this.head == null) {
                        this.tail = null;
                    }
                    return false;
                }
            }
            if (this.head == null) {
                this.tail = null;
            }
            return true;
        }
        else {
            return false;
        }
    }

    public void removeAll(int _value)
    {
        if (this.head != null) {
            Node current = this.head;
            while (current != null) {
                if (this.head == null) {
                    this.tail = null;
                    break;
                }
                if (current.value == _value) {
                    if (current == this.head) {
                        this.head = this.head.next;
                        if (this.head != null) {
                            this.head.prev = null;
                        }
                    }
                    else if (current == this.tail) {
                        this.tail = this.tail.prev;
                        this.tail.next = null;
                    }
                    else {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                    }
                    if (this.head == null) {
                        this.tail = null;
                    }
                }
                current = current.next;
            }
        }
    }

    public void clear()
    {
        if (this.head != null) {
            while (this.head != this.tail) {
                this.head = this.head.next;
            }
            this.head = null;
            this.tail = null;
        }
    }

    public int count()
    {
        Node current = head;
        int cnt = 0;
        while (current != null) {
            cnt++;
            current = current.next;
        }
        return cnt;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert)
    {
        if (_nodeAfter == this.head) {
            if (this.head == null || this.head == this.tail) {
                this.addInTail(_nodeToInsert);
            }
            else {
                this.head.next.prev = _nodeToInsert;
                _nodeToInsert.next = this.head.next;
                this.head.next = _nodeToInsert;
                _nodeToInsert.prev = this.head;
            }
        }
        else if (_nodeAfter == this.tail) {
            addInTail(_nodeToInsert);
        }
        else if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            if (this.head != null) {
                this.head.prev = _nodeToInsert;
            }
            this.head = _nodeToInsert;
        }
        else {
            _nodeAfter.next.prev = _nodeToInsert;
            _nodeToInsert.next = _nodeAfter.next;
            _nodeAfter.next = _nodeToInsert;
            _nodeToInsert.prev = _nodeAfter;
        }
    }

    public boolean check() {
        Node current = this.head;
        Node rcurrent = this.tail;
        int forward = 0, backward = 0;
        while (current != null) {
            current = current.next;
            forward++;
        }

        while (rcurrent != null) {
            rcurrent = rcurrent.prev;
            backward++;
        }

        return forward == backward;
    }

    public void display() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.print("\n");
    }

    public void displayHeadAndTail() {
        System.out.println("Head: " + this.head + " Tail: " + this.tail);
    }
}

class Node  {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value)
    {
        value = _value;
        next = null;
        prev = null;
    }
}