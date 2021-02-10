package main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();

    Stack<Integer> aa = new Stack<>();
    Stack<Integer> bb = new Stack<>();

    int [] aValues = {1, 2, 3, 4, 5};
    int [] bValues = {};

    int [] aPopValues = {1, 2, 3, 4};
    int [] bPopValues = {};

    int [] aPushValues = {1, 2, 3, 4, 5, 6};
    int [] bPushValues = {6};

    void initStack(Stack<Integer> s, int [] values) {
        for (int item : values) {
            s.push(item);
        }
    }

    boolean compareStacks(Stack<Integer> a, Stack<Integer> b) {
        if (a.size() == b.size() && a.capacity == b.capacity) {
            while (a.size() > 0) {
                if (a.pop() != b.pop()) {
                    return false;
                }
            }
        }
        return true;
    }

    void clearStack(Stack<Integer> s) {
        while (s.size() > 0) {
            s.pop();
        }
    }

    @AfterEach
    void clear() {
        clearStack(a);
        clearStack(b);
        clearStack(aa);
        clearStack(bb);
    }

    @Test
    void size() {
        initStack(a, aValues);
        initStack(b, bValues);

        assertEquals(5, a.size());
        assertEquals(0, b.size());
    }

    @Test
    void pop() {
        initStack(a, aValues);
        initStack(b, bValues);

        assertEquals(5, a.pop());
        assertNull(b.pop());

        initStack(aa, aPopValues);
        initStack(bb, bPopValues);

        assertTrue(compareStacks(a, aa));
        assertTrue(compareStacks(b, bb));
    }

    @Test
    void push() {
        initStack(a, aValues);
        initStack(b, bValues);

        a.push(6);
        b.push(6);

        initStack(aa, aPushValues);
        initStack(bb, bPushValues);

        assertTrue(compareStacks(a, aa));
        assertTrue(compareStacks(b, bb));
    }

    @Test
    void peek() {
        initStack(a, aValues);
        initStack(b, bValues);

        assertEquals(5, a.peek());
        assertEquals(5, a.size());
        assertNull(b.peek());
        assertEquals(0, b.size());
    }
}