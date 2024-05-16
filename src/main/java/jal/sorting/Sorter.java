package org.jal.sorting;

import java.util.Comparator;
import org.jal.sorting.strategy.SortStrategy;

public class Sorter {
  public static <T> T[] sortArray(T[] arr, SortStrategy<T> strat, Comparator<T> comp) {
    return strat.sortArray(arr, comp);
  }

  public static <T extends Comparable<? super T>> T[] sortArray(T[] arr, SortStrategy<T> strat) {
    Comparator<T> identity = Comparator.comparing(v -> v);

    return Sorter.sortArray(arr, strat, identity);
  }
}
