package net.davehughes.algorithms.sorting;

import net.davehughes.algorithms.utils.TestUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

public class HeapSort {

  private static void printArray(int[] values) {
    for (int i = 0; i < values.length; i++) {
      System.out.println("a[" + i + "] = " + values[i]);
    }
  }

  private static void buildHeap(int[] values, int n) {
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(values, i, n);
    }
  }

  private static void heapify(int[] values, int i, int max) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int largest;

    /* Find largest element of values[i], values[left] and values[right] */
    if (left < max && values[left] > values[i]) {
      largest = left;
    } else {
      largest = i;
    }

    if (right < max && values[right] > values[largest]) {
      largest = right;
    }

    /* If largest is not already the parent then swap and propagate */
    if (largest != i) {
      swap(values, i, largest);
      heapify(values, largest, max);
    }
  }

  private static void swap(int[] values, int i, int j) {
    int temp = values[i];
    values[i] = values[j];
    values[j] = temp;
  }

  public static void sort(int[] values) {
    buildHeap(values, values.length);

    for (int i = values.length - 1; i > 0; i--) {
      swap(values, 0, i);
      heapify(values, 0, i);
    }
  }

  public static void main(final String[] args) {
    int[] values = TestUtils.generateIntegerValues();

    System.out.println(Arrays.toString(values));

    sort(values);

    System.out.println(Arrays.toString(values));
  }
}
