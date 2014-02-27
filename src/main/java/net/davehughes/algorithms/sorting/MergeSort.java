package net.davehughes.algorithms.sorting;

import net.davehughes.algorithms.utils.TestUtils;

import java.util.Arrays;

public class MergeSort {

  public static void mergeSort(int[] values) {
    int[] helper = new int[values.length];
    mergeSort(values, helper, 0, values.length - 1);
  }

  private static void mergeSort(int[] values, int[] helper, int low, int high) {
    if (low < high) {
      int middle = low + (high - low) / 2;

      // Sort left half
      mergeSort(values, helper, low, middle);

      // Sort right half
      mergeSort(values, helper, middle + 1, high);

      // Merge the two halves
      merge(values, helper, low, middle, high);
    }
  }

  private static void merge(int[] values, int[] helper, int low, int middle, int high) {
    // Copy both halves into a helper array
    for (int i = low; i <= high; i++) {
      helper[i] = values[i];
    }

    int helperLeft = low;
    int helperRight = middle + 1;
    int current = low;

    /*
     * Iterate through helper array. Compare the left and right half, copying back the smaller
     * element from the two halves into the original array.
     */
    while (helperLeft <= middle && helperRight <= high) {
      if (helper[helperLeft] <= helper[helperRight]) {
        // If left element is smaller than or equal to right element
        values[current] = helper[helperLeft];
        helperLeft++;
      } else {
        // If right element is smaller than left element
        values[current] = helper[helperRight];
        helperRight++;
      }

      current++;
    }

    // Copy the rest of the left side of the array into the target array
    int remaining = middle - helperLeft;
    for (int i = 0; i <= remaining; i++) {
      values[current + i] = helper[helperLeft + i];
    }
  }

  public static void main(String[] args) {
    int n = 10;
    int max = 9;

    int[] values = TestUtils.generateIntegerValues(n, max);

    System.out.println(Arrays.toString(values));

    mergeSort(values);

    System.out.println(Arrays.toString(values));
  }
}
