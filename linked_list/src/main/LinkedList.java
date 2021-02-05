import java.util.*;

public class LinkedList
{
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null) {
            this.head = item;
        }
        else {
            this.tail.next = item;
        }
        this.tail = item;
    }

    public Node find(int value) {
        Node current = this.head;
        while (current != null) {
            if (current.value == value) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
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

    public boolean remove(int _value) {
        Node previous = null, current = this.head;
        while (current != null) {
            if (current.value == _value) {
                if (current == this.head) {
                    this.head = this.head.next;
                }
                else if (current == tail) {
                    current = null;
                    this.tail = previous;
                    previous.next = null;
                }
                else {
                    previous.next = current.next;
                    current = null;
                }
                if (this.head == null) {
                    this.tail = null;
                }
                return true;
            }
            else {
                previous = current;
                current = current.next;
            }
        }
        return false;
    }

    public void removeAll(int _value) {
        Node previous = null, current = this.head;
        while (current != null) {
            if (current.value == _value) {
                if (current == this.head) {
                    previous = current;
                    this.head = this.head.next;
                }
                else if (current == this.tail) {
                    current = null;
                    this.tail = previous;
                    previous.next = null;
                }
                else {
                    previous.next = current.next;
                    current = current.next;
                }
                if (this.head == null) {
                    this.tail = null;
                    current = null;
                }
            }
            else {
                previous = current;
                current = current.next;
            }
        }
    }

    public void clear() {
        if (this.head != null) {
            while (this.head != this.tail) {
                this.head = this.head.next;
            }
            this.head = null;
            this.tail = null;
        }
    }

    public int count() {
        Node current = head;
        int cnt = 0;
        while (current != null) {
            cnt++;
            current = current.next;
        }
        return cnt;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == this.head) {
            if (this.head == null) {
                this.addInTail(_nodeToInsert);
            }
            else {
                _nodeToInsert.next = this.head.next;
                this.head.next = _nodeToInsert;
            }
        }
        else if (_nodeAfter == this.tail) {
            this.addInTail(_nodeToInsert);
        }
        else if (_nodeAfter == null) {
            _nodeToInsert.next = this.head;
            this.head = _nodeToInsert;
        }
        else {
            Node current = this.head;
            while (current != null && current.value != _nodeAfter.value) {
                current = current.next;
            }
            if (current != null) {
                _nodeToInsert.next = current.next;
                current.next = _nodeToInsert;
            }
        }
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

class Node {
    public int value;
    public Node next;
    public Node(int _value) {
        value = _value;
        next = null;
    }
}
