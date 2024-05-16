package org.jal.sorting.strategy;

import static org.jal.util.Arrays.swap;
import static org.jal.util.Comparators.isGreaterThan;
import java.util.Comparator;

public class InsertionSortStrategy<T> implements SortStrategy<T> {
  public T[] sortArray(T[] arr, Comparator<T> comparator) {
    int size = arr.length;

    for (int i = 1; i < size; ++i) {
      int j = i-1;
      while (j >= 0 && isGreaterThan(arr[j], arr[j+1], comparator)) {
        swap(arr, j, j+1);
        j--;
      }
    }

    return arr;
  }
}
