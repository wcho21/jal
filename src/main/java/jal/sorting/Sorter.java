package org.jal.sorting;

import java.util.Comparator;
import org.jal.sorting.strategy.SortStrategy;

public class Sorter {
  public static <T> T[] sortArray(T[] arr, int begin, int end, SortStrategy<T> strat, Comparator<T> comp) {
    return strat.sortArray(arr, begin, end, comp);
  }

  public static <T> T[] sortArray(T[] arr, SortStrategy<T> strat, Comparator<T> comp) {
    return Sorter.sortArray(arr, 0, arr.length, strat, comp);
  }

  public static <T extends Comparable<? super T>> T[] sortArray(T[] arr, int begin, int end, SortStrategy<T> strat) {
    Comparator<T> identityComp = Comparator.comparing(v -> v);

    return strat.sortArray(arr, begin, end, identityComp);
  }

  public static <T extends Comparable<? super T>> T[] sortArray(T[] arr, SortStrategy<T> strat) {
    return Sorter.sortArray(arr, 0, arr.length, strat);
  }
}
