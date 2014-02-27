package net.davehughes.algorithms.sorting;

import java.util.Arrays;

/**
 * This is a simple implementation of QuickSort that operates on an array of integers.
 */
public class QuickSort {
  public static void sort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  private static void quickSort(int[] arr, int left, int right) {
    int index = partition(arr, left, right);

    if (left < index - 1) {
      // Sort left half
      quickSort(arr, left, index - 1);
    }

    if (index < right) {
      // Sort right half
      quickSort(arr, index, right);
    }
  }

  private static int partition(int[] arr, int left, int right) {
    // Pick pivot point to be in the middle
    int pivot = arr[(left + right) / 2];

    while (left <= right) {
      // Find element on left that should be on right
      while (arr[left] < pivot) {
        left++;
      }

      // Find element on right that should be on left
      while (arr[right] > pivot) {
        right--;
      }

      // Swap elements, and move left and right indices
      if (left <= right) {
        swap(arr, left, right);
        left++;
        right--;
      }
    }

    return left;
  }

  private static void swap(int[] arr, int left, int right) {
    int tmp = arr[left];
    arr[left] = arr[right];
    arr[right] = tmp;
  }

  public static void main(String[] args) {
    int[] values = {4, 2, 7, 1, 3, 8, 5, 9, 0, 6};
    sort(values);
    System.out.println(Arrays.toString(values));
  }
}
