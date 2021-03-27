package main;

import java.lang.reflect.Array;

public class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;
    private int BASE;
    private int step;
    private int occupied;

    public NativeCache(int _size, int _step, Class cls) {
        size = _size;
        slots = new String[size];
        values = (T[]) Array.newInstance(cls, size);
        hits = new int[size];
        BASE = 2011;
        step = _step;
        occupied = 0;
    }

    private int getHash(String value) {
        int hash = 0;
        int len = value.length();
        for (int i = 0; i < len; ++i) {
            hash *= BASE;
            hash += (int)value.charAt(i);
            hash %= size;
        }

        return hash;
    }

    private int getMinHits() {
        int _min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < size; ++i) {
            if (hits[i] < _min) {
                _min = hits[i];
                idx = i;
            }
        }
        return idx;
    }

    private int freeSlot() {
        int idx = getMinHits();
        hits[idx] = 0;
        values[idx] = null;
        slots[idx] = null;
        occupied--;
        return idx;
    }

    private int seekSlot(String key, int hash) {
        if (occupied == size) {
            return freeSlot();
        } else {
            int firstHash = hash;
            boolean passed = false;
            while (slots[hash] != null) {
                if (slots[hash].equals(key)) {
                    break;
                }
                hash += step;
                if (hash >= size) {
                    passed = true;
                    hash %= size;
                }
                if (passed && hash >= firstHash) {
                    break;
                }
            }
            if ((slots[hash] != null && !slots[hash].equals(key)) || passed && hash >= firstHash) {
                return -1;
            }
            else {
                return hash;
            }
        }
    }

    public void put(String key, T value) {
        int idx = seekSlot(key, getHash(key));
        if (idx == -1) {
            throw new IndexOutOfBoundsException("Error");
        }
        else {
            occupied++;
            slots[idx] = key;
            values[idx] = value;
        }
    }

    private int getHelper(String key) {
        int idx = getHash(key);
        int firstIdx = idx;
        boolean passed = false;
        while (true) {
            if (slots[idx] != null) {
                if (slots[idx].equals(key)) {
                    break;
                }
            }
            idx += step;
            if (idx >= size) {
                passed = true;
                idx %= size;
            }
            if (passed && idx >= firstIdx) {
                break;
            }
        }
        if (slots[idx] == null || !slots[idx].equals(key) || passed && idx >= firstIdx) {
            return -1;
        }
        return idx;
    }

    public boolean isKey(String key) {
        return getHelper(key) != -1;
    }

    public T get(String key) {
        int idx = getHelper(key);
        if (idx != -1) {
            hits[idx]++;
            return values[idx];
        }
        else {
            return null;
        }
    }

    public void outputNonNull() {
        for (int i = 0; i < size; ++i) {
            if (slots[i] != null) {
                System.out.println(i + " - " + slots[i] + " : " + values[i] + ", hits: " + hits[i]);
            }
        }
    }
}
