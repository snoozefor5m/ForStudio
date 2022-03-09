package main.java.leetcode.sort;

import java.util.Arrays;

public class SortingAlgorithm {

    public static void main(String[] args) {
        /** Test
         *
         */
        int[] test1 = new int[]{2,5,1,6};
        System.out.println("Before sort: " + Arrays.toString(test1));
        SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
        sortingAlgorithm.quickSort(test1);
        System.out.println("After quick sort: " + Arrays.toString(test1));

    }

    /** Quick sort
     * @param arr The array to be sorted.
     */
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = begin;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, end);
        return i;
    }

    private void swap(int[] arr, int firstIndex, int secondIndex) {
        int swapTemp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = swapTemp;
    }

    /** Merge sort
     * @param arr The array to be sorted.
     */
    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            mergeSort(arr, begin, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, begin, mid, end);
        }
    }

    private void merge(int[] arr, int begin, int mid, int end) {
        int i = begin;
        int j = mid+1;
        int[] temp = new int[end - begin + 1];
        int k = 0;
        while( i <= mid && j <= end)
        {
            if (arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= end) {
            temp[k++] = arr[j++];
        }
        for (int pointer = begin; pointer <= end; pointer++) {
            arr[pointer] = temp[pointer - begin];
        }
    }
}
