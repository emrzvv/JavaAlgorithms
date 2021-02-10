package main;
import java.lang.reflect.Array;
import java.util.*;

public class Stack<T>
{
    public T[] data;
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

    public Stack()
    {
        count = 0;
        capacity = MINIMAL_CAPACITY;
        initArray(capacity);
    }

    public int size()
    {
        return count;
    }

    public T pop()
    {
        if (count == 0) {
            return null;
        }
        else {
            if (count < capacity / 2) {
                if (capacity * 2 / 3 < MINIMAL_CAPACITY) {
                    initArray(MINIMAL_CAPACITY);
                }
                else {
                    initArray(capacity * 2 / 3);
                }
            }
            return data[--count];
        }
    }

    public void push(T val)
    {
        if (count == capacity) {
            initArray(capacity * 2);
        }
        data[count++] = val;
    }

    public T peek()
    {
        if (count == 0) {
            return null;
        }
        else {
            return data[count - 1];
        }
    }

    public void outputData() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}