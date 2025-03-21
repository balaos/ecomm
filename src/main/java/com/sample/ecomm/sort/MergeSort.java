package com.sample.ecomm.sort;

import java.util.Arrays;

class MergeSort {
    public void sort(int[] arr) {
        if (arr.length < 2) return;
        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);
    }

    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        merge(arr, left, mid, right, temp);
    }

    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];
        System.arraycopy(temp, left, arr, left, right - left + 1);
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 5, 2, 7, 4, 1};
        MergeSort sorter = new MergeSort();
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5, 6, 7, 8]
    }
}
