package net.davehughes.algorithms.utils;

import java.util.Random;
import java.util.Scanner;

/**
 * Contains helper methods for testing.
 */
public class TestUtils {

  /**
   * Returns an array of randomised integers. Prompts for two values on the standard input, the size
   * of the array and the maximum possible value of any integer in the array.
   *
   * @return array of random integers
   */
  public static int[] generateIntegerValues() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Array size: ");
    int n = scanner.nextInt();

    System.out.print("Max value: ");
    int max = scanner.nextInt();

    scanner.close();

    return generateIntegerValues(n, max);
  }

  /**
   * Returns an array of {@code n} integers between 0 and {@code max}.
   *
   * @param n the size of the array
   * @param max the maximum possible value of any item in the array
   * @return array of random integers
   */
  public static int[] generateIntegerValues(int n, int max) {
    final Random randomGenerator = new Random();

    // Create array of size n
    int[] values = new int[n];
    int randomUpperBound = max + 1;

    // Fill array with random values in the specified range
    for (int i = 0; i < n; i++) {
      values[i] = randomGenerator.nextInt(randomUpperBound);
    }

    return values;
  }
}
