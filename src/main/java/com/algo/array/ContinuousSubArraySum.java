package com.algo.array;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {

    /***
     * Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose
     * elements sum up to a multiple of k, or false otherwise.
     * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of
     *
     * Input: nums = [23,2,4,6,7], k = 6
     * Output: true
     * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
     *
     * @tags prefix sum, hashmap
    */
    public boolean checkSubarraySum(int[] nums, int k) {
        //Map the remainder -> index
        Map<Integer, Integer> map = new HashMap<>();

        //to handle edge case when the first n is multiple of k
        map.put(0, -1);
        //initialize the running sum
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];

            //put if map does not have that remainder
            if(!map.containsKey(sum%k)) {
                map.put(sum%k, i);
            } else if(map.containsKey(sum%k) && i - map.get(sum%k) > 1) {
                return true;
            }
        }

        return false;

    }
}
