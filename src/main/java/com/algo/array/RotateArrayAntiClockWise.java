package com.algo.array;

import com.algo.utils.ArrayUtils;

public class RotateArrayAntiClockWise {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 6, 6, 2, 62};
        rotateArr( arr, 3, 7);
        ArrayUtils.printArray(arr);

    }

    //Time O(N)
    static void rotateArr(int arr[], int d, int n)
    {

        if(d > arr.length){
            d = d % arr.length;
        }
        //part1
        Reverse(arr,0,d-1);

        //part II

        Reverse(arr,d,n-1);
        //part III
        Reverse(arr,0,n-1);
    }

    public static void Reverse(int []arr,int i,int j){
        int li = i;
        int ri = j;

        while(li<=ri){
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;

            li++;
            ri--;
        }
    }

    static void rotateArrUnOptimized(int arr[], int d, int n)
    {
        // add your code here

        for(int i=0; i < d ; i++) {
            int temp = arr[0];
            int j = 0;

            while( j < n-1) {
                arr[j] = arr[j+1];
                j++;
            }
            arr[n - 1] = temp;
        }

    }

    static void shift(int n,int[] arr, int till) {
        for(int i=0; i < n - 1; i++) {
            arr[i] = arr[i+1];
        }
    }
}
