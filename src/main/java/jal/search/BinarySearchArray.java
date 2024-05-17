package org.jal.search;

import static org.jal.util.Comparators.isEqualTo;
import static org.jal.util.Comparators.isLessThan;
import java.util.Comparator;

public class BinarySearchArray {
  public static <T> int search(T[] arr, T target, Comparator<T> comp) {
    int begin = 0;
    int end = arr.length;
    while (begin < end) {
      int mid = begin + (end - begin) / 2;
      T midVal = arr[mid];

      if (isEqualTo(midVal, target, comp)) {
        return mid;
      }

      if (isLessThan(midVal, target, comp)) {
        begin = mid+1;
      } else {
        end = mid;
      }
    }

    return -1;
  }

  public static <T extends Comparable<? super T>> int search(T[] arr, T target) {
    Comparator<T> identityComp = Comparator.comparing(v -> v);

    return BinarySearchArray.search(arr, target, identityComp);
  }
}
