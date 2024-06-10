package org.jal.sorting.strategy.arrays;

import java.util.Comparator;

public interface ArraySortStrategy<T> {
  public T[] sortArray(T[] arr, int begin, int end, Comparator<T> comp);
}
