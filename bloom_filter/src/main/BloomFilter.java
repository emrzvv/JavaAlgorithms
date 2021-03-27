package main;

public class BloomFilter
{
    public int filter_len;
    private int checker;
    private final int BASE_1 = 17;
    private final int BASE_2 = 223;

    public BloomFilter(int f_len)
    {
        filter_len = f_len;
        checker = 0;
    }

    public int hash1(String str1)
    {
        int hash = 0;
        for(int i=0; i<str1.length(); i++)
        {
            int code = (int)str1.charAt(i);
            hash = hash * BASE_1 + code;
            hash %= filter_len;
        }
        return hash;
    }

    public int hash2(String str1)
    {
        int hash = 0;
        for (int i =  0; i < str1.length(); ++i) {
            int code = (int)(str1).charAt(i);
            hash = hash * BASE_2 + code;
            hash %= filter_len;
        }
        return hash;
    }

    public void add(String str1)
    {
        int hash = hash1(str1);
        //System.out.println(hash);
        checker |= (1 << hash);
        //System.out.println(String.format("%32s", Integer.toBinaryString(checker).replaceAll(" ", "0")));
        hash = hash2(str1);
        //System.out.println(hash);
        checker |= (1 << hash);
        //System.out.println(String.format("%32s", Integer.toBinaryString(checker).replaceAll(" ", "0")));
    }

    public boolean isValue(String str1)
    {
        int hash = hash1(str1);
        System.out.println(hash);
        if ((checker & (1 << hash)) == 0) {
            return false;
        }
        hash = hash2(str1);
        System.out.println(hash);
        if ((checker & (1 << hash)) == 0) {
            return false;
        }
        return true;
    }
}