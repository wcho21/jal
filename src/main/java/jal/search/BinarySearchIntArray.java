package org.jal.search;

public class BinarySearchIntArray {
  public static int search(int[] arr, int target) {
    int begin = 0;
    int end = arr.length;
    while (begin < end) {
      int mid = begin + (end - begin) / 2;
      int midVal = arr[mid];

      if (midVal == target) {
        return mid;
      }

      if (midVal < target) {
        begin = mid+1;
      } else {
        end = mid;
      }
    }

    return -1;
  }
}
