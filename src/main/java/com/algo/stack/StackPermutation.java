package com.algo.stack;

import java.util.Stack;
//
//Input:
//        N = 3
//        A = {1,2,3}
//        B = {2,1,3}
//        Output:
//        1
//        Explanation:
//        1. push 1 from A to stack
//        2. push 2 from A to stack
//        3. pop 2 from stack to B
//        4. pop 1 from stack to B
//        5. push 3 from A to stack
//        6. pop 3 from stack to B
public class StackPermutation {

    /*
    * You are given two arrays A and B of unique elements of size N. Check if one array is a stack permutation of the other array or not.
        Stack permutation means that one array can be created from another array using a stack and stack operations.
    * */
    public static int isStackPermutation(int n, int[] ip, int[] op) {

        Stack<Integer> stack = new Stack<>();

        int k=0;
        for( int i=0; i < n; i++) {
            stack.push(ip[i]);

            while( !stack.isEmpty() && stack.peek() == op[k]) {
                stack.pop();
                k++;
            }
        }

        return stack.isEmpty() ? 1 : 0;

    }
}
