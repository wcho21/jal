package org.jal.sorting.strategy.arrays;

import java.util.Comparator;
import org.jal.sorting.ArraySorter;

public class TopDownInsMergeStrategy<T> extends AbstractMergeStrategy<T> {
  private static int THRESHOLD = 7;

  @Override
  protected void mergeSortArray(T[] arr, int begin, int end, Comparator<T> comp) {
    if (end - begin <= 1) {
      return;
    }

    // do insertion sort if small
    if (end - begin <= THRESHOLD) {
      ArraySorter.sortArray(arr, begin, end, new InsertionStrategy<>(), comp);
      return;
    }

    int mid = begin + (end - begin) / 2;

    this.mergeSortArray(arr, begin, mid, comp);
    this.mergeSortArray(arr, mid, end, comp);
    this.mergeArrays(arr, begin, mid, end, comp);
  }
}
