package org.jal.sorting;

import java.util.Comparator;

import org.jal.sorting.strategy.arrays.ArraySortStrategy;

public class ArraySorter {
  public static <T> T[] sortArray(T[] arr, int begin, int end, ArraySortStrategy<T> strat, Comparator<T> comp) {
    return strat.sortArray(arr, begin, end, comp);
  }

  public static <T> T[] sortArray(T[] arr, ArraySortStrategy<T> strat, Comparator<T> comp) {
    return ArraySorter.sortArray(arr, 0, arr.length, strat, comp);
  }

  public static <T extends Comparable<? super T>> T[] sortArray(T[] arr, int begin, int end, ArraySortStrategy<T> strat) {
    Comparator<T> identityComp = Comparator.comparing(v -> v);

    return ArraySorter.sortArray(arr, begin, end, strat, identityComp);
  }

  public static <T extends Comparable<? super T>> T[] sortArray(T[] arr, ArraySortStrategy<T> strat) {
    return ArraySorter.sortArray(arr, 0, arr.length, strat);
  }
}
