package net.davehughes.algorithms.searching;

public class BinarySearch {
  public static int search(int[] values, int target) {
    int low = 0;
    int high = values.length - 1;
    int middle;

    while (low <= high) {
      middle = (low + high) / 2;

      if (values[middle] < target) {
        low = middle + 1;
      } else if (values[middle] > target) {
        high = middle - 1;
      } else {
        return middle;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    int index = search(values, 6);
    System.out.println(index);
  }
}
