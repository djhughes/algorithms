package net.davehughes.algorithms.sorting;

import net.davehughes.algorithms.utils.TestUtils;

import java.util.Arrays;

/**
 * Simple implementation of QuickSort that operates on an array of integers.
 */
public class QuickSort {
  public static void sort(int[] values) {
    quickSort(values, 0, values.length - 1);
  }

  private static void quickSort(int[] values, int left, int right) {
    int index = partition(values, left, right);

    if (left < index - 1) {
      // Sort left half
      quickSort(values, left, index - 1);
    }

    if (index < right) {
      // Sort right half
      quickSort(values, index, right);
    }
  }

  private static int partition(int[] values, int left, int right) {
    // Pick pivot point to be in the middle
    int pivot = values[(left + right) / 2];

    while (left <= right) {
      // Find element on left that should be on right
      while (values[left] < pivot) {
        left++;
      }

      // Find element on right that should be on left
      while (values[right] > pivot) {
        right--;
      }

      // Swap elements, and move left and right indices
      if (left <= right) {
        swap(values, left, right);
        left++;
        right--;
      }
    }

    return left;
  }

  private static void swap(int[] values, int left, int right) {
    int tmp = values[left];
    values[left] = values[right];
    values[right] = tmp;
  }

  public static void main(String[] args) {
    int n = 10;
    int max = 9;

    int[] values = TestUtils.generateIntegerValues(n, max);

    System.out.println(Arrays.toString(values));

    sort(values);

    System.out.println(Arrays.toString(values));
  }
}
