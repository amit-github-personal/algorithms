package com.algo.strings;

public class MinCharToPalindrome {

    //KMP Algo for pattern searching
    public static int minChar(String str) {
        StringBuilder s = new StringBuilder();
        s.append(str);

        // Get concatenation of string, special character
        // and reverse string
        String rev = s.reverse().toString();
        s.reverse().append("$").append(rev);
        int[] lps = computeLPSArray(s.toString());

        return str.length() - lps[s.length() -1];
    }

    static int[] computeLPSArray(String str) {
        //Initialize LPS Array
        int[] lps = new int[str.length()];
        int i = 1, len = 0;
        //LPS at 0 will be 0
        lps[0] = 0;

        while(i < str.length()) {
            if(str.charAt(i) == str.charAt(len)) {
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
        return lps;
    }

    public static void main(String[] args) {
        System.out.println(minChar("abc"));
    }
}
