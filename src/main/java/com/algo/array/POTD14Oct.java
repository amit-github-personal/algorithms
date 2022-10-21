package com.algo.array;

import java.util.HashMap;
import java.util.Map;

public class POTD14Oct {

    public static void main(String[] args) {
        System.out.println(maximizeSum(new int[]{9, 15, 9, 3, 8, 4, 6, 17, 7, 11, 17, 7, 3, 18, 13, 9, 7, 12, 2,8}, 20));
    }

    // Function for finding maximum and value pair
    public static int maximizeSum (int arr[], int n) {
        //Complete the function
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n ; i++) {
            int val = map.get(arr[i]) == null ? 1 : map.get(arr[i]) + 1;
            map.put(arr[i], val);
        }

        int sum = 0;

        for(int i = n - 1; i >= 0; i--) {
            if(map.get(arr[i]) > 0) {
                sum += arr[i];
                map.put(arr[i], map.get(arr[i]) - 1);
                if(map.containsKey(arr[i] -1) && map.get(arr[i] - 1) > 0) {
                    map.put(arr[i] - 1, map.get(arr[i] -1) - 1);
                }
            }
        }
        return sum;
    }
}
