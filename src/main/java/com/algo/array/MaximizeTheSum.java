package com.algo.array;

import java.util.HashMap;
import java.util.Map;

public class MaximizeTheSum {

    public static void main(String[] args) {
        System.out.println(maximizeSum(new int[]{9, 15, 9, 3, 8, 4, 6, 17, 7, 11, 17, 7, 3, 18, 13, 9, 7, 12, 2,8}, 20));
    }

    /**
     * Maximize the sum of selected numbers from a sorted array to make it empty
     *
     * Given a array of N numbers, we need to maximize the sum of selected numbers.
     * At each step, you need to select a number Ai, delete one occurrence of Ai-1 (if exists),
     * and Ai each from the array. Repeat these steps until the array gets empty.
     * The problem is to maximize the sum of the selected numbers.
     *
     * Input : arr[ ] = {1, 2, 2, 2, 3, 4}
     * Output : 10
     * Explanation:
     * We select 4, so 4 and 3 are deleted leaving us with {1,2,2,2}.
     * Then we select 2, so 2 & 1 are deleted. We are left with{2,2}.
     * We select 2 in next two steps, thus the sum is 4+2+2+2=10.
     *
     * */
    public static int maximizeSum (int arr[], int n) {
        //map the no -> freq
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
