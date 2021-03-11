package main;

class Pair {
    private final int first;
    private final int second;

    public Pair(int _first, int _second) {
        this.first = _first;
        this.second = _second;
    }

    public int getFirst() {
        return this.first;
    }

    public int getSecond() {
        return this.second;
    }
}

public class PowerSet
{
    private final int[] powers;
    private final int BASE = 2017;
    private final int slotSize;
    private String[][] slots;
    private int size;
    private int MOD = size;
    private int amount;

    public PowerSet()
    {
        size = 20000;
        slotSize = 50;
        amount = 0;
        MOD = size;

        powers = new int[size];
        slots = new String[size][slotSize];

        powers[0] = 1;
        for (int j = 0; j < slotSize; ++j) {
            slots[0][j] = null;
        }

        for (int i = 1; i < size; ++i) {
            powers[i] = (powers[i - 1] * BASE + MOD) % MOD;
            for (int j = 0; j < slotSize; ++j) {
                slots[i][j] = null;
            }
        }

    }

    public int hashFun(String value)
    {
        int n = value.length();
        int hash = 0;
        for (int i = 0; i < n; ++i) {
            hash += powers[i] * ((int)value.charAt(i) + 1);
            hash += MOD;
            hash %= MOD;
        }
        return hash;
    }

    private Pair seekSlot(String value) {
        int hash = hashFun(value);

        for (int i = 0; i < slotSize; ++i) {
            if (slots[hash][i] != null && slots[hash][i].equals(value)) {
                amount--;
                return new Pair(hash, i);
            }
        }
        for (int i = 0; i < slotSize; ++i) {
            if (slots[hash][i] == null) {
                return new Pair(hash, i);
            }
        }
        return null;
    }

    public int size()
    {
        return amount;
    }


    public void put(String value)
    {
        Pair seekResult = seekSlot(value);
        int hashIdx = seekResult.getFirst();
        int posIdx = seekResult.getSecond();
        slots[hashIdx][posIdx] = value;
        amount++;
    }

    public boolean get(String value)
    {
        int hash = hashFun(value);
        for (int i = 0; i < slotSize; ++i) {
            if (slots[hash][i] != null && slots[hash][i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    public boolean remove(String value)
    {
        int hash = hashFun(value);
        for (int i = 0; i < slotSize; ++i) {
            if (slots[hash][i] != null && slots[hash][i].equals(value)) {
                slots[hash][i] = null;
                amount--;
                return true;
            }
        }
        return false;
    }

    public PowerSet intersection(PowerSet set2)
    {
        PowerSet result = new PowerSet();
        for (int i = 0; i < set2.size; ++i) {
            for (int j = 0; j < set2.slotSize; ++j) {
                if (set2.slots[i][j] != null) {
                    if (get(set2.slots[i][j])) {
                        result.put(set2.slots[i][j]);
                    }
                }
            }
        }
        return result;
    }

    public PowerSet union(PowerSet set2)
    {
        PowerSet result = new PowerSet();
        for (int i = 0; i < set2.size; ++i) {
            for (int j = 0; j < set2.slotSize; ++j) {
                if (set2.slots[i][j] != null) {
                    result.put(set2.slots[i][j]);
                }
                else if (this.slots[i][j] != null) {
                    result.put(this.slots[i][j]);
                }
            }
        }
        return result;
    }

    public PowerSet difference(PowerSet set2)
    {
        PowerSet _union = this.union(set2);
        PowerSet _intersection = this.intersection(set2);
        PowerSet result = new PowerSet();

        for (int i = 0; i < _union.size; ++i) {
            for (int j = 0; j < _union.slotSize; ++j) {
                if (_union.slots[i][j] != null && !_intersection.get(_union.slots[i][j])) {
                    result.put(_union.slots[i][j]);
                }
            }
        }

        return result;
    }

    public boolean isSubset(PowerSet set2)
    {
        for (int i = 0; i < set2.size; ++i) {
            for (int j = 0; j < set2.slotSize; ++j) {
                if (set2.slots[i][j] != null && !this.get(set2.slots[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public void display() {
        for (int i = 0; i < this.size; ++i) {
            for (int j = 0; j < this.slotSize; ++j) {
                if (slots[i][j] != null) {
                    System.out.print(slots[i][j] + " ");
                }
            }
        }
        System.out.println();
    }
}
