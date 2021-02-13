package main;

import java.util.*;

public class Queue<T>
{
    public T [] data;
    public int capacity;
    public int count;
    final public int MINIMAL_CAPACITY = 16;

    public void initArray(int new_capacity)
    {
        if (this.data == null) {
            data = (T[]) new Object[new_capacity];
        }
        else {
            T [] holdData = data.clone();
            data = (T[]) new Object[new_capacity];
            System.arraycopy(holdData, 0, data, 0, count);
        }
        capacity = new_capacity;
    }

    public Queue()
    {
        count = 0;
        capacity = MINIMAL_CAPACITY;
        initArray(capacity);
    }

    public void enqueue(T item)
    {
        if (count == capacity) {
            initArray(capacity * 2);
        }
        data[count++] = item;
    }

    public T dequeue()
    {
        if (count == 0) {
            return null;
        }
        else {
            T result = data[0];
            if (count < capacity / 2) {
                if (capacity * 2 / 3 < MINIMAL_CAPACITY) {
                    initArray(MINIMAL_CAPACITY);
                }
                else {
                    initArray(capacity * 2 / 3);
                }
            }
            --count;
            for (int i = 0; i < count; ++i) {
                data[i] = data[i + 1];
            }
            data[count] = null;
            return result;
        }
    }

    public int size()
    {
        return this.count;
    }

    public void display() {
        for (int i = 0; i < count; ++i) {
            System.out.print(this.data[i] + " ");
        }
        System.out.println();
    }
}
