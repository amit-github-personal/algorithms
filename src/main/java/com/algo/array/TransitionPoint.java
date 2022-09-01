package com.algo.array;

public class TransitionPoint {

    //[0, 0, 0, 0, 1, , 1]
    //Complexity O(nlogn)
    int transitionPoint(int arr[], int n) {
        if ( n == 1 && arr[0] == 1) return 0;

        int mid = n / 2;

        if( arr[mid] == 0) {
            for( int i = mid + 1; i < n; i ++) {
                if(arr[i] == 1) {
                    return i;
                }
            }
        } else if( arr[ mid ]== 1) {
            for(int i=0; i <= mid; i++) {
                if(arr[ i] == 1) {
                    return i;
                }
            }
        } else {
            return -1;
        }
        return -1;
    }
}
