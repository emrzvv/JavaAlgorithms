package main;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

class DynArrayTest {

    DynArray a = new DynArray(Integer.class);
    DynArray b = new DynArray(Integer.class);
    DynArray c = new DynArray(Integer.class);

    DynArray aa = new DynArray(Integer.class);
    DynArray bb = new DynArray(Integer.class);
    DynArray cc = new DynArray(Integer.class);

    int[] aValues = {1, 2, 3, 4, 5};
    int[] bValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    int[] cValues = {};

    int[] aInsertedValues = {1, 2, 3, 4, 5, 6};
    int[] bInsertedValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};
    int[] cInsertedValues = {1};

    int[] aRemovedValues = {1, 2, 4, 5};
    int[] bRemovedValues = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    int[] cRemovedValues = {};

    void fillDynArray(DynArray d, int[] values) {
        for (int item : values) {
            d.append(item);
        }
    }

    void clearDynArray(DynArray d) {
        while (d.count > 0) {
            d.remove(0);
        }
    }

    boolean compareDynArrays(DynArray a, DynArray b) {
        if (a.capacity == b.capacity && a.count == b.count) {
            for (int i = 0; i < a.count; ++i) {
                if (!a.getItem(i).equals(b.getItem(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @AfterEach
    void clearAllDynArrays() {
        clearDynArray(a);
        clearDynArray(aa);
        clearDynArray(b);
        clearDynArray(bb);
        clearDynArray(c);
        clearDynArray(cc);
    }

    @Test
    void insert() {
        fillDynArray(a, aValues);
        fillDynArray(aa, aInsertedValues);
        a.insert(6, 5);
        assertTrue(compareDynArrays(a, aa));

        fillDynArray(b, bValues);
        fillDynArray(bb, bInsertedValues);
        b.insert(17, 16);
        assertTrue(compareDynArrays(b, bb));

        fillDynArray(c, cValues);
        fillDynArray(cc, cInsertedValues);
        c.insert(1, 0);
        assertTrue(compareDynArrays(c, cc));

        clearDynArray(aa);
        clearDynArray(a);
        fillDynArray(aa, aValues);
        fillDynArray(a, aValues);
        a.insert(-1, -1);
        assertTrue(compareDynArrays(a, aa));
    }

    @Test
    void remove() {
        fillDynArray(a, aValues);
        fillDynArray(aa, aRemovedValues);
        a.remove(2);
        assertTrue(compareDynArrays(a, aa));

        fillDynArray(b, bInsertedValues);
        fillDynArray(bb, bRemovedValues);
        b.remove(16);
        b.remove(15);
        bb.capacity = 32 * 2 / 3;
        assertTrue(compareDynArrays(b, bb));

        fillDynArray(c, cValues);
        fillDynArray(cc, cValues);
        c.remove(3);
        assertTrue(compareDynArrays(c, cc));
    }
}