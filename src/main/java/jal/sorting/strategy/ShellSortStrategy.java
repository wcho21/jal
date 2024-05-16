package org.jal.sorting.strategy;

import static org.jal.util.Arrays.swap;
import static org.jal.util.Comparators.isGreaterThan;
import java.util.Comparator;

public class ShellSortStrategy<T> implements SortStrategy<T> {
  public T[] sortArray(T[] arr, Comparator<T> comparator) {
    int size = arr.length;

    int gap = 1;
    while (gap < size / 3) {
      gap = 3*gap + 1;
    }

    while (gap >= 1) {
      for (int i = gap; i < size; ++i) {
        int j = i - gap;
        while (j >= 0 && isGreaterThan(arr[j], arr[j+gap], comparator)) {
          swap(arr, j, j+gap);
          j -= gap;
        }
      }

      gap /= 3;
    }

    return arr;
  }
}
