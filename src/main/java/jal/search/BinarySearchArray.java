package org.jal.search;

import static org.jal.util.Comparators.isEqualTo;
import static org.jal.util.Comparators.isLessThan;
import java.util.Comparator;

public class BinarySearchArray {
  public static <T> int search(T[] arr, T target, Comparator<T> comparator) {
    int size = arr.length;

    int low = 0;
    int high = size;
    while (low < high) {
      int mid = low + (high - low) / 2;
      T midVal = arr[mid];

      if (isEqualTo(midVal, target, comparator)) {
        return mid;
      }

      if (isLessThan(midVal, target, comparator)) {
        low = mid+1;
      } else {
        high = mid;
      }
    }

    return -1;
  }

  public static <T extends Comparable<? super T>> int search(T[] arr, T target) {
    return BinarySearchArray.search(arr, target, Comparator.comparing(v -> v));
  }
}
