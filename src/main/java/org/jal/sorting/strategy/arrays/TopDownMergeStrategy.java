package org.jal.sorting.strategy.arrays;

import java.util.Comparator;

public class TopDownMergeStrategy<T> extends AbstractMergeStrategy<T> {
  @Override
  protected void mergeSortArray(T[] arr, int begin, int end, Comparator<T> comp) {
    if (end - begin <= 1) {
      return;
    }

    int mid = begin + (end - begin) / 2;

    this.mergeSortArray(arr, begin, mid, comp);
    this.mergeSortArray(arr, mid, end, comp);
    this.mergeArrays(arr, begin, mid, end, comp);
  }
}
