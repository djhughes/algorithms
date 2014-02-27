package net.davehughes.algorithms.sorting;

import net.davehughes.algorithms.utils.TestUtils;

import java.util.Arrays;

public class BucketSort {

  public static void sort(int[] values, int maxValue) {
    int[] bucket = new int[maxValue + 1];

    for (int i = 0; i < values.length; i++) {
      // Increment the count in the bucket identified by the value from the input array
      bucket[values[i]]++;
    }

    // For each bucket that has a value > 0, add the bucket index to the values array as many times
    // as the value in that bucket.
    int outIndex = 0;
    for (int i = 0; i < bucket.length; i++) {
      for (int j = 0; j < bucket[i]; j++) {
        values[outIndex++] = i;
      }
    }
  }

  public static void main(String[] args) {
    int n = 12;
    int max = 5;

    int[] values = TestUtils.generateIntegerValues(n, max);

    System.out.println(Arrays.toString(values));

    sort(values, max);

    System.out.println(Arrays.toString(values));
  }
}
