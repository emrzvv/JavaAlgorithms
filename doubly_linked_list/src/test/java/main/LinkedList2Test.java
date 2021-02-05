package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.util.ArrayList;
import java.util.Arrays;

class LinkedList2Test {
    public LinkedList2 e = new LinkedList2();
    public LinkedList2 a = new LinkedList2();
    public LinkedList2 b = new LinkedList2();
    public LinkedList2 c = new LinkedList2();
    public LinkedList2 d = new LinkedList2();

    public LinkedList2 ee = new LinkedList2();
    public LinkedList2 aa = new LinkedList2();
    public LinkedList2 bb = new LinkedList2();
    public LinkedList2 cc = new LinkedList2();
    public LinkedList2 dd = new LinkedList2();

    public int [] values_e = {};
    public int [] values_a = {1, 2, 3, 4, 5};
    public int [] values_b = {1};
    public int [] values_c = {1, 2};
    public int [] values_d = {1, 1, 2, 3, 3};

    public int [] tail_values_e = {9}; // {} => {9}
    public int [] tail_values_a = {1, 2, 3, 4, 5, 9}; // {1, 2, 3, 4, 5} => {1, 2, 3, 4, 5, 9}
    public int [] tail_values_b = {1, 9}; // {1} => {1, 9}
    public int [] tail_values_c = {1, 2, 9}; // {1, 2} => {1, 2, 9}

    public Node [] found_nodes_e = {};
    public Node [] found_nodes_a = {new Node(3)};
    public Node [] found_nodes_b = {};
    public Node [] found_nodes_c = {new Node(2)};
    public Node [] found_nodes_d = {new Node(3), new Node(3)};

    public int [] removed_values_e = {}; // false, {} => {}
    public int [] removed_values_a = {1, 2, 3, 4}; // true, {1, 2, 3, 4, 5} => {1, 2, 3, 4}
    public int [] removed_values_b = {}; // true, {1} => {}
    public int [] removed_values_c = {1, 2}; // false, {1, 2} => {1, 2}
    public int [] removed_values_d = {1, 1, 2, 3}; // true, {1, 1, 2, 3, 3} => {1, 1, 2, 3}

    public int [] removedAll_values_e = {}; // false, {} => {}
    public int [] removedAll_values_a = {2, 3, 4, 5}; // true, {1, 2, 3, 4, 5} => {2, 3, 4, 5}
    public int [] removedAll_values_b = {}; // true, {1} => {}
    public int [] removedAll_values_c = {1, 2}; // false, {1, 2} => {1, 2}
    public int [] removedAll_values_d = {2, 3, 3}; // true, {1, 1, 2, 3, 3} => {2, 3, 3}
    public int [] removedAll_values_dd = {2}; // true, {2, 3, 3} => {2}

    public int [] insertedAfter_values_e_1 = {9}; // after head {} => {9}
    public int [] insertedAfter_values_e_2 = {9}; // after tail {} => {9}
    public int [] insertedAfter_values_a_1 = {1, 9, 2, 3, 4, 5}; // after head {1, 2, 3, 4, 5} => {1, 9, 2, 3, 4, 5}
    public int [] insertedAfter_values_a_2 = {1, 2, 9, 3, 4, 5}; // after find(2) {1, 2, 3, 4, 5} => {1, 2, 9, 3, 4, 5}
    public int [] insertedAfter_values_a_3 = {1, 2, 3, 4, 5, 9}; // after tail {1, 2, 3, 4, 5} => {1, 2, 3, 4, 5, 9}
    public int [] insertedAfter_values_b_1 = {1, 9}; // after head {1} => {1, 9}
    public int [] insertedAfter_values_b_2 = {1, 9}; // after tail {1} => {1, 9}
    public int [] insertedAfter_values_b_3 = {1, 9}; // after find(1) {1} => {1, 9}

    public void initLinkedList(LinkedList2 list, int [] values) {
        for (int value : values) {
            Node n = new Node(value);
            list.addInTail(n);
        }
    }

    public boolean compareLinkedLists(LinkedList2 a, LinkedList2 b) {
        if (a.count() == b.count()) {
            Node a_current = a.head;
            Node b_current = b.head;
            while (a_current != null) {
                if (a_current.value != b_current.value) {
                    return false;
                }
                a_current = a_current.next;
                b_current = b_current.next;
            }
            return true;
        }
        else {
            return false;
        }
    }

    public boolean compareNodes(Node a, Node b) {
        if (a == null || b == null) {
            return false;
        }
        return a.value == b.value;
    }

    public boolean compareArrayListNodes(ArrayList<Node> a, ArrayList<Node> b) {
        int n = a.size();
        for (int i = 0; i < n; ++i) {
            if (!compareNodes(a.get(i), b.get(i))) {
                return false;
            }
        }
        return true;
    }

    @BeforeEach
    void initLists() {
        initLinkedList(e, values_e);
        initLinkedList(a, values_a);
        initLinkedList(b, values_b);
        initLinkedList(c, values_c);
        initLinkedList(d, values_d);
    }

    @AfterEach
    void clearLists() {
        e.clear();
        a.clear();
        b.clear();
        c.clear();
        d.clear();

        ee.clear();
        aa.clear();
        bb.clear();
        cc.clear();
        dd.clear();
    }

    @Test
    @DisplayName("Add in tail")
    void addInTail() {
        Node n = new Node(9);

        e.addInTail(n);
        initLinkedList(ee, tail_values_e);
        assertTrue(compareLinkedLists(e, ee));
        assertTrue(e.check());

        a.addInTail(n);
        initLinkedList(aa, tail_values_a);
        assertTrue(compareLinkedLists(a, aa));
        assertTrue(a.check());

        b.addInTail(n);
        initLinkedList(bb, tail_values_b);
        assertTrue(compareLinkedLists(b, bb));
        assertTrue(b.check());

        c.addInTail(n);
        initLinkedList(cc, tail_values_c);
        assertTrue(compareLinkedLists(c, cc));
        assertTrue(c.check());
    }

    @Test
    @DisplayName("Find")
    void find() {
        Node ef = null;
        Node af = new Node(3);
        Node bf = new Node(1);
        Node cf = null;

        assertFalse(compareNodes(e.find(5), ef));
        assertTrue(compareNodes(a.find(3), af));
        assertTrue(compareNodes(b.find(1), bf));
        assertFalse(compareNodes(c.find(-1), cf));
    }

    @Test
    @DisplayName("Find All: ")
    void findAll() {
        ArrayList<Node> en = new ArrayList<Node>(Arrays.asList(found_nodes_e));
        ArrayList<Node> an = new ArrayList<Node>(Arrays.asList(found_nodes_a));
        ArrayList<Node> bn = new ArrayList<Node>(Arrays.asList(found_nodes_b));
        ArrayList<Node> cn = new ArrayList<Node>(Arrays.asList(found_nodes_c));
        ArrayList<Node> dn = new ArrayList<Node>(Arrays.asList(found_nodes_d));

        assertTrue(compareArrayListNodes(e.findAll(9), en));
        assertTrue(compareArrayListNodes(a.findAll(3), an));
        assertTrue(compareArrayListNodes(b.findAll(0), bn));
        assertTrue(compareArrayListNodes(c.findAll(2), cn));
        assertTrue(compareArrayListNodes(d.findAll(3), dn));
    }

    @Test
    @DisplayName("Remove")
    void remove() {
        assertFalse(e.remove(9));
        initLinkedList(ee, removed_values_e);
        assertTrue(compareLinkedLists(e, ee));
        assertTrue(e.check());

        assertTrue(a.remove(5));
        initLinkedList(aa, removed_values_a);
        assertTrue(compareLinkedLists(a, aa));
        assertTrue(a.check());

        assertTrue(b.remove(1));
        initLinkedList(bb, removed_values_b);
        assertTrue(compareLinkedLists(b, bb));
        assertTrue(b.check());

        assertFalse(c.remove(0));
        initLinkedList(cc, removed_values_c);
        assertTrue(compareLinkedLists(c, cc));
        assertTrue(c.check());

        assertTrue(d.remove(3));
        initLinkedList(dd, removed_values_d);
        assertTrue(compareLinkedLists(d, dd));
        assertTrue(d.check());
    }

    @Test
    @DisplayName("Remove All")
    void removeAll() {
        e.removeAll(9);
        initLinkedList(ee, removedAll_values_e);
        assertTrue(compareLinkedLists(e, ee));
        assertTrue(e.check());

        a.removeAll(1);
        initLinkedList(aa, removedAll_values_a);
        assertTrue(compareLinkedLists(a, aa));
        assertTrue(a.check());

        b.removeAll(1);
        initLinkedList(bb, removedAll_values_b);
        assertTrue(compareLinkedLists(b, bb));
        assertTrue(b.check());

        c.removeAll(0);
        initLinkedList(cc, removedAll_values_c);
        assertTrue(compareLinkedLists(c, cc));
        assertTrue(c.check());

        d.removeAll(1);
        initLinkedList(dd, removedAll_values_d);
        assertTrue(compareLinkedLists(d, dd));
        assertTrue(d.check());

        d.removeAll(3);
        dd.clear();
        initLinkedList(dd, removedAll_values_dd);
        assertTrue(compareLinkedLists(d, dd));
        assertTrue(d.check());
    }


    @Test
    @DisplayName("Count")
    void count() {
        assertEquals(e.count(), 0);
        assertEquals(a.count(), 5);
        assertEquals(b.count(), 1);
        assertEquals(c.count(), 2);
        assertEquals(d.count(), 5);
    }

    @Test
    @DisplayName("Insert After")
    void insertAfter() {
        e.insertAfter(e.head, new Node(9));
        initLinkedList(ee, insertedAfter_values_e_1);
        assertTrue(compareLinkedLists(e, ee));
        assertTrue(e.check());
        ee.clear();
        e.clear();

        e.insertAfter(e.tail, new Node(9));
        initLinkedList(ee, insertedAfter_values_e_2);
        assertTrue(compareLinkedLists(e, ee));
        assertTrue(e.check());

        a.insertAfter(a.head, new Node(9));
        initLinkedList(aa, insertedAfter_values_a_1);
        assertTrue(compareLinkedLists(a, aa));
        assertTrue(a.check());
        aa.clear();
        a.clear();

        initLinkedList(a, values_a);
        a.insertAfter(a.find(2), new Node(9));
        initLinkedList(aa, insertedAfter_values_a_2);
        assertTrue(compareLinkedLists(a, aa));
        assertTrue(a.check());
        aa.clear();
        a.clear();

        initLinkedList(a, values_a);
        a.insertAfter(a.tail, new Node(9));
        initLinkedList(aa, insertedAfter_values_a_3);
        assertTrue(compareLinkedLists(a, aa));
        assertTrue(a.check());
        aa.clear();
        a.clear();

        b.insertAfter(b.head, new Node(9));
        initLinkedList(bb, insertedAfter_values_b_1);
        assertTrue(compareLinkedLists(b, bb));
        assertTrue(b.check());
        bb.clear();
        b.clear();

        initLinkedList(b, values_b);
        b.insertAfter(b.tail, new Node(9));
        initLinkedList(bb, insertedAfter_values_b_2);
        assertTrue(compareLinkedLists(b, bb));
        assertTrue(b.check());
        bb.clear();
        b.clear();

        initLinkedList(b, values_b);
        b.insertAfter(b.find(1), new Node(9));
        initLinkedList(bb, insertedAfter_values_b_3);
        assertTrue(compareLinkedLists(b, bb));
        assertTrue(b.check());
        bb.clear();
        b.clear();
    }
}