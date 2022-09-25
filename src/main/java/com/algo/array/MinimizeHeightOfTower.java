package com.algo.array;

import java.util.Arrays;

public class MinimizeHeightOfTower {

    public static void main(String[] args) {
        MinimizeHeightOfTower sol = new MinimizeHeightOfTower();
        System.out.println(sol.getMinDiff(new int[]{1, 3, 4, 5, 5}, 5, 2));
    }

    int getMinDiff(int[] arr, int n, int k) {

        Arrays.sort(arr);

        int currentAns = arr[n-1] - arr[0];

        int smallest = arr[0] + k;
        int largest = arr[n - 1 ] -k;
        int minI; int maxI;

        for(int i=0; i < n -1; i++) {
            minI = Math.min(smallest, arr[i + 1] -k);
            maxI = Math.max(largest, arr[i] + k);

            if(minI < 0) continue;
            currentAns = Math.min(currentAns, maxI - minI);
        }
        return currentAns;
    }
}
