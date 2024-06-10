package org.jal.sorting.strategy.arrays;

import static org.jal.util.Arrays.swap;
import static org.jal.util.Comparators.isGreaterThan;
import java.util.Comparator;

public class ShellStrategy<T> implements ArraySortStrategy<T> {
  public T[] sortArray(T[] arr, int begin, int end, Comparator<T> comp) {
    int h = 1;
    while (h < (end - begin) / 3) {
      h = 3*h + 1;
    }

    while (h >= 1) {
      for (int i = begin+h; i < end; ++i) {
        int j = i - h;
        while (j >= begin && isGreaterThan(arr[j], arr[j+h], comp)) {
          swap(arr, j, j+h);
          j -= h;
        }
      }

      h /= 3;
    }

    return arr;
  }
}
