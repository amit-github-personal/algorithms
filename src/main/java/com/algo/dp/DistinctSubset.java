package com.algo.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given a set of integers, find all distinct sums that can be generated from the subsets of the given sets.
*
* Input: nums = {1,2}
Output: {0,1,2,3}
Explanation: Four distinct sums can be
calculated which are 0, 1, 2 and 3.
0 if we do not choose any number.
1 if we choose only 1.
2 if we choose only 2.
3 if we choose 1 and 2.
* */
public class DistinctSubset {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        DistinctSubset sol = new DistinctSubset();
        sol.DistinctSum(nums);
    }

    public int[] DistinctSum(int[] nums) {
        int sum = 0;

        for(int i = 0; i < nums.length;i++){
            sum = sum + nums[i];
        }
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        for(int j = 0; j < dp.length ; j++){
            dp[j][0] = true;
        }
        for(int i = 1; i <= nums.length; i++){
            for(int j = 1; j <= sum ; j++){
                if(nums[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0 ; i <= sum ; i++){
            if(dp[nums.length][i]){
                result.add(i);
            }
        }
        int[] res = new int[result.size()];
        for(int i = 0; i < result.size();i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}
