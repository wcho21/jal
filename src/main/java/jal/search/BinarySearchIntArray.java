package org.jal.search;

public class BinarySearchIntArray {
  public static int search(int[] arr, int target) {
    int size = arr.length;

    int low = 0;
    int high = size;
    while (low < high) {
      int mid = low + (high - low) / 2;
      int midVal = arr[mid];

      if (midVal == target) {
        return mid;
      }

      if (midVal < target) {
        low = mid+1;
      } else {
        high = mid;
      }
    }

    return -1;
  }
}
