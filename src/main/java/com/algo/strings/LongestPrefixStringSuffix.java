package com.algo.strings;

public class LongestPrefixStringSuffix {

    int lps(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int i = 1, len = 0;
        lps[0] = 0;

        while(i < n) {
            if(s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if( len != 0) {
                    len = lps[len -1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps[s.length() -1];
    }
}
