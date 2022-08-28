package com.algo.array;

public class MissingNumberArray {

    
}

class Solution {
    int MissingNumber(int array[], int n) {
        int summation=(n*(n+1))/2;

        int originalSum = 0;
        for(int i=0; i < array.length; i++) {
            originalSum += array[i];
        }
        return summation - originalSum;
    }
}
