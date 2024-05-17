package org.jal.sorting.strategy;

import static org.jal.util.Arrays.swap;
import static org.jal.util.Comparators.isGreaterThan;
import java.util.Comparator;

public class InsertionStrategy<T> implements SortStrategy<T> {
  public T[] sortArray(T[] arr, int begin, int end, Comparator<T> comp) {
    for (int i = begin+1; i < end; ++i) {
      int j = i-1;
      while (j >= begin && isGreaterThan(arr[j], arr[j+1], comp)) {
        swap(arr, j, j+1);
        j--;
      }
    }

    return arr;
  }
}
