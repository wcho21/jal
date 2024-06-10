package org.jal.sorting.strategy;

import java.util.Comparator;

public interface SortStrategy<T> {
  public T[] sortArray(T[] arr, int begin, int end, Comparator<T> comp);
}
