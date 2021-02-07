import java.lang.reflect.Array;
import java.util.*;

public class DynArray<T>
{
    public T [] array;
    public int count;
    public int capacity;
    final public int MINIMAL_CAPACITY = 16;
    Class clazz;

    public DynArray(Class clz)
    {
        clazz = clz; // нужен для безопасного приведения типов
        count = 0;
        capacity = MINIMAL_CAPACITY;
        makeArray(MINIMAL_CAPACITY);
    }

    public void makeArray(int new_capacity)
    {
        if (this.array == null) {
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
        }
        else {
            T [] holdArray = array.clone();
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
            System.arraycopy(holdArray, 0, array, 0, count);
        }

        capacity = new_capacity;
    }

    public T getItem(int index)
    {
        if (0 <= index && index < count) {
            return array[index];
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
        return null;
    }

    public void append(T itm)
    {
        if (count == capacity) {
            makeArray(capacity * 2);
        }
        array[count++] = itm;
    }

    public void insert(T itm, int index)
    {
        if (0 <= index && index <= count) {
            if (count == capacity) {
                makeArray(capacity * 2);
            }
            for (int i = count; i > index; --i) {
                array[i] = array[i - 1];
            }
            array[index] = itm;
            count++;
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void remove(int index)
    {
        if (0 <= index && index < count) {
            for (int i = index; i < count; ++i) {
                array[i] = array[i + 1];
            }
            array[count--] = null;
            if (count < capacity / 2) {
                if (capacity * 2 / 3 < MINIMAL_CAPACITY) {
                    makeArray(MINIMAL_CAPACITY);
                }
                else {
                    makeArray(capacity * 2 / 3);
                }
            }
        }
        else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void display() {
        System.out.println("Capacity: " + this.capacity + ", Count: " + this.count);
        for (int i = 0; i < count; ++i) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

}
