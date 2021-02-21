package main;

public class HashTable
{
    private final int [] powers;

    public int size;
    public int step;
    public String [] slots;
    public int BASE = 2017;
    public int MOD;
    public boolean empty;

    public HashTable(int _size, int _step)
    {
        size = _size;
        step = _step;
        MOD = size;
        empty = true;
        slots = new String[size];
        powers = new int[size];
        powers[0] = 1;
        for (int i = 0; i < size; ++i) {
            if (i > 0) {
                powers[i] = (powers[i - 1] * BASE + MOD) % MOD;
            }
            slots[i] = null;
        }
    }


    public int hashFun(String value)
    {
        int n = value.length();
        int hash = 0;
        for (int i = 0; i < n; ++i) {
            hash += powers[i] * (value.charAt(i) - 'a' + 1);
            hash += MOD;
            hash %= MOD;
        }
        return hash;
    }

    public int seekSlot(String value)
    {
        int hash = hashFun(value);
        if (!empty) {
            int firstHash = hash;
            boolean passed = false;
            while (slots[hash] != null) {
                hash += step;
                if (hash >= size) passed = true;
                hash %= MOD;
                if (passed && hash >= firstHash) {
                    break;
                }
            }
            if (slots[hash] != null || passed && hash >= firstHash) {
                return -1;
            }
            else {
                return hash;
            }
        }
        else {
            empty = false;
            slots[hash] = value;
            return hash;
        }
    }

    public int put(String value)
    {
        int idx = seekSlot(value);
        if (idx != -1) {
            slots[idx] = value;
        }
        return idx;
    }

    public int find(String value)
    {
        int hash = hashFun(value);
        int firstHash = hash;
        boolean passed = false;
        while (slots[hash] != null && slots[hash].compareTo(value) != 0) {
            hash += step;
            if (hash >= size) {
                passed = true;
            }
            hash %= MOD;
            if (passed && hash >= firstHash) {
                break;
            }
        }
        if (slots[hash] == null || slots[hash].compareTo(value) != 0) {
            return -1;
        }
        else {
            return hash;
        }
    }

    public void outputNonNull() {
        for (int i = 0; i < size; ++i) {
            if (slots[i] != null ){
                System.out.println(i + " - " + slots[i]);
            }
        }
    }
}
