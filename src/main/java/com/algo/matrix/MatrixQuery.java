package com.algo.matrix;

public class MatrixQuery {

//     You are given a matrix of dimension n*n. All the cells are initially, zero. You are given Q queries, which contains 4 integers a b c d where (a,b) is the TOP LEFT cell and (c,d) is the Bottom Right cell of a submatrix. Now, all the cells of this submatrix have to be incremented by one. After all the Q queries have been performed. Your task is to find the final resulting Matrix.
// Note : Zero-Based Indexing is used for cells of the matrix. 
 

// Example 1:

// Input: n = 6, q = 6,
// Queries = {
// {4,0,5,3},
// {0,0,3,4},
// {1,2,1,2},
// {1,1,2,3},
// {0,0,3,1},
// {1,0,2,4}}.
// Output: 
// 2 2 1 1 1 0
// 3 4 4 3 2 0 
// 3 4 3 3 2 0
// 2 2 1 1 1 0
// 1 1 1 1 0 0
// 1 1 1 1 0 0
// Explanation:After incrementing all the
// sub-matrices of given queries we will 
// get the final output.

 

 

// Example 2:

// Input: n = 4, q = 2,
// Queries = {
// {0,0,3,3},
// {0,0,2,2}}.
// Output: 
// 2 2 2 1 
// 2 2 2 1  
// 2 2 2 1 
// 1 1 1 1 
// Explanation:After incrementing all the
// sub-matrices of given queries we will
// get the final output.


    public int[][] solveQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];
        
        for( int[] query : queries) {
            int a = query[0];
            int b = query[1];
            int c = query[2];
            int d = query[3];
            
            for(int i = a; i <=c; i++){
                mat[i][b] +=1;
                if(d + 1 < n) mat[i][d+1] -=1;
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                mat[i][j] += mat[i][j-1];
            }
        }
        return mat;
    }
}


