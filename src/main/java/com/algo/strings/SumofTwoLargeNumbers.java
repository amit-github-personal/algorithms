package com.algo.strings;

import java.util.Date;

public class SumofTwoLargeNumbers {

    public static void main(String[] args) {
        String s1 = "454646546709396412620629286296078368866266297068421405425244843899898426245063817157711255932243423295811517100838801957742186421740441523535518511718404612557651698950423196258329381762117874254279211732357101259328759749184501645918245187322484251447365937301814839359003461099133981675607708284331451799198213721901661362382936071361";
        String s2 = "4545454539031371702810453098018578414127242601772955922421455202353987804064231649151415780203758048048457872157064128708940216242047104883098924639621";

        Solution sol = new Solution ();
        long start = System.currentTimeMillis ();
        System.out.println (sol.findSum (s1, s2));
        long end = System.currentTimeMillis ();

        System.out.println ("Took " + (end - start) + " millis ");
    }
}

class Solution {
    String findSum(String X, String Y) {
        int carry = 0;
        StringBuilder result = new StringBuilder ();
        int x=1, y=1;

        while( x <= X.length() && y <= Y.length()) {

            int num1 = X.charAt(X.length() - x) - '0';
            int num2 = Y.charAt(Y.length() - y) - '0';
            int sum = num1 + num2 + carry;
            carry = 0;

            if(sum > 9) {
                result.insert (0, sum % 10);
                carry = 1;
            } else {
                result.insert (0, sum);
            }
            x++;y++;
        }

        for(; x <= X.length(); x++) {
            int remaining = X.charAt(X.length() - x) - '0';
            int sum = remaining + carry;
            carry = 0;

            if(sum > 9) {
                result.insert (0, sum % 10);
                carry = 1;
            } else {
                result.insert (0, sum);
            }
        }

        for(; y <= Y.length(); y++) {
            int remaining = Y.charAt(Y.length() - y) - '0';
            int sum = remaining + carry;
            carry = 0;

            if(sum > 9) {
                result.insert (0, sum % 10);
                carry = 1;
            } else {
                result.insert (0, sum);
            }
        }

        if(carry > 0) result.insert (0, carry);

        return result.toString ().replaceAll("^0+(?!$)", "");
    }
}