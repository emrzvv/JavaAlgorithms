package main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    public Queue<Integer> a = new Queue<>();
    public Queue<Integer> b = new Queue<>();

    public Queue<Integer> aa = new Queue<>();
    public Queue<Integer> bb = new Queue<>();

    int [] aValues = {1, 2, 3, 4, 5};
    int [] bValues = {};

    int [] aEnqueueValues = {1, 2, 3, 4, 5, 6};
    int [] bEnqueueValues = {1};

    int [] aDequeValues = {2, 3, 4, 5};
    int [] bDequeValues = {};

    public void initQueue(Queue<Integer> q, int [] values) {
        for (int item : values) {
            q.enqueue(item);
        }
    }

    public void clearQueue(Queue<Integer> q) {
        while (q.size() > 0) {
            q.dequeue();
        }
    }

    public boolean compareQueues(Queue<Integer> a, Queue<Integer> b) {
        if (a.size() == b.size() && a.capacity == b.capacity) {
            while (a.size() > 0) {
                if (a.dequeue() != b.dequeue()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @AfterEach
    void clearQueues() {
        clearQueue(a);
        clearQueue(b);
        clearQueue(aa);
        clearQueue(bb);
    }

    @Test
    void enqueue() {
        initQueue(a, aValues);
        initQueue(b, bValues);
        a.enqueue(6);
        b.enqueue(1);
        initQueue(aa, aEnqueueValues);
        initQueue(bb, bEnqueueValues);
        assertTrue(compareQueues(a, aa));
        assertTrue(compareQueues(b, bb));
    }

    @Test
    void dequeue() {
        initQueue(a, aValues);
        assertEquals(1, a.dequeue());
        initQueue(aa, aDequeValues);
        assertTrue(compareQueues(a, aa));

        initQueue(b, bValues);
        assertNull(b.dequeue());
        initQueue(bb, bDequeValues);
        assertTrue(compareQueues(b, bb));
    }

    @Test
    void size() {
        initQueue(a, aValues);
        initQueue(b, bValues);
        assertEquals(5, a.size());
        assertEquals(0, b.size());
    }
}