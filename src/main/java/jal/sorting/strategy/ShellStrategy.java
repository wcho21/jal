package org.jal.sorting.strategy;

import static org.jal.util.Arrays.swap;
import static org.jal.util.Comparators.isGreaterThan;
import java.util.Comparator;

public class ShellStrategy<T> implements SortStrategy<T> {
  public T[] sortArray(T[] arr, int begin, int end, Comparator<T> comp) {
    int gap = 1;
    while (gap < (end - begin) / 3) {
      gap = 3*gap + 1;
    }

    while (gap >= 1) {
      for (int i = begin+gap; i < end; ++i) {
        int j = i - gap;
        while (j >= begin && isGreaterThan(arr[j], arr[j+gap], comp)) {
          swap(arr, j, j+gap);
          j -= gap;
        }
      }

      gap /= 3;
    }

    return arr;
  }
}
