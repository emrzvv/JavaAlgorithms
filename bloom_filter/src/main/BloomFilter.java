package main;

public class BloomFilter
{
    public int filter_len;
    private int[] checker;
    private final int BASE_1 = 17;
    private final int BASE_2 = 223;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        checker = new int[filter_len];
        for (int i = 0; i < filter_len; ++i) {
            checker[i] = 0;
        }
    }

    public int hash1(String str1)
    {
        int hash = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            hash *= BASE_1;
            hash += code;
            hash %= filter_len;
        }
        return hash & (filter_len - 1);
    }

    public int hash2(String str1)
    {
        int hash = 0;
        for (int i =  0; i < str1.length(); ++i) {
            int code = (int)(str1).charAt(i);
            hash *= BASE_2;
            hash += code;
            hash %= filter_len;
        }
        return hash & (filter_len - 1);
    }

    public void add(String str1)
    {
        int hash = hash1(str1);
        checker[hash >>> 6]|= 1 << hash;
        hash = hash2(str1);
        checker[hash >>> 6] |= 1 << hash;
    }

    public boolean isValue(String str1)
    {
        int hash = hash1(str1);
        if ((checker[hash >>> 6] & (1 << hash)) == 0) {
            return false;
        }
        hash = hash2(str1);
        if ((checker[hash >>> 6] & (1 << hash)) == 0) {
            return false;
        }
        return true;
    }
}