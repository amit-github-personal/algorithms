package com.algo.sorting;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{43, 235, 63, 24, 66, 24};
        quickSort.sort(arr, 0, arr.length -1);

        for( int a : arr) System.out.print(a + " ");
    }

    public void sort(int[] arr, int start, int end) {
        if( start >= end) return;
        int pivotIndex = partition(arr, start, end);
        sort(arr, start, pivotIndex -1);
        sort(arr, pivotIndex + 1, end);
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int elementsLessThanPivot = 0;

        for(int i = start + 1; i <= end; i++) {
            if(arr[i] <= pivot) elementsLessThanPivot++;
        }

        int pivotIndex = start + elementsLessThanPivot;
        arr[start] = arr[pivotIndex];
        arr[pivotIndex] = pivot;

        while( start < pivotIndex && end > pivotIndex) {
            while( arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;

            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
        return pivotIndex;
    }
}
