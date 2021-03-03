package main;

import java.lang.reflect.Array;

class NativeDictionary<T>
{
    public int size;
    public String [] slots;
    public T [] values;
    private int MOD;
    private int BASE = 2017;
    private int step = 3;
    private final int [] powers;


    public NativeDictionary(int sz, Class clazz)
    {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        MOD = size;
        powers = new int[size];
        slots[0] = null;
        values[0] = null;
        powers[0] = 1;
        for (int i = 1; i < size; ++i) {
            powers[i] = (powers[i - 1] * BASE + MOD) % MOD;
            slots[i] = null;
            values[i] = null;
        }
    }

    public int seekSlot(String key, int hash) {
        int firstHash = hash;
        boolean passed = false;
        while (slots[hash] != null) {
            if (slots[hash].equals(key)) {
                break;
            }
            hash += step;
            if (hash >= size) passed = true;
            hash %= MOD;
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

    public int hashFun(String key)
    {
        int n = key.length();
        int hash = 0;
        for (int i = 0; i < n; ++i) {
            hash += powers[i] * ((int)key.charAt(i) + 1);
            hash += MOD;
            hash %= MOD;
        }
        return hash;
    }

    private int getHelper(String key) {
        int idx = hashFun(key);
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
            }
            idx %= MOD;
            if (passed && idx >= firstIdx) {
                break;
            }
        }
        if (slots[idx] == null || !slots[idx].equals(key) || passed && idx >= firstIdx) {
            return -1;
        }
        return idx;
    }

    public boolean isKey(String key)
    {
        return getHelper(key) != -1;
    }

    public void put(String key, T value)
    {
        int idx = seekSlot(key, hashFun(key));
        slots[idx] = key;
        values[idx] = value;
    }

    public T get(String key)
    {
        int idx = getHelper(key);
        if (idx != -1) {
            return values[idx];
        }
        else {
            return null;
        }
    }

    public void outputNonNull() {
        for (int i = 0; i < size; ++i) {
            if (slots[i] != null) {
                System.out.println(i + " - " + slots[i] + " : " + values[i]);
            }
        }
    }
}
